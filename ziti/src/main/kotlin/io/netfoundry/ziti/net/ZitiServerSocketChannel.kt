/*
 * Copyright (c) 2018-2020 NetFoundry, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.netfoundry.ziti.net

import com.goterl.lazycode.lazysodium.utils.Key
import io.netfoundry.ziti.ZitiAddress
import io.netfoundry.ziti.api.SessionType
import io.netfoundry.ziti.crypto.Crypto
import io.netfoundry.ziti.impl.ZitiContextImpl
import io.netfoundry.ziti.net.nio.FutureHandler
import io.netfoundry.ziti.util.Logged
import io.netfoundry.ziti.util.ZitiLog
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.net.BindException
import java.net.SocketAddress
import java.net.SocketOption
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future
import kotlinx.coroutines.channels.Channel as Chan

internal class ZitiServerSocketChannel(val ctx: ZitiContextImpl): AsynchronousServerSocketChannel(null),
    Channel.MessageReceiver, Logged by ZitiLog() {

    var localAddr: ZitiAddress.Service? = null
    lateinit var channel: Channel
    var connId: Int = -1
    var state: State = State.initial
    lateinit var incoming: Chan<Message>
    lateinit var token: String
    internal val keyPair = Crypto.newKeyPair()

    enum class State {
        initial,
        binding,
        bound,
        closed
    }

    override fun isOpen(): Boolean = state != State.closed

    override fun bind(local: SocketAddress?, backlog: Int): AsynchronousServerSocketChannel {
        if (local !is ZitiAddress.Service) throw UnsupportedAddressTypeException()
        when(state) {
            State.initial -> {}
            State.binding,
            State.bound -> throw AlreadyBoundException()
            State.closed -> throw ClosedChannelException()
        }

        runBlocking {
            try {
                val session = ctx.getNetworkSession(local.name, SessionType.Bind)
                token = session.token
                channel = ctx.getChannel(session)
                connId = channel.registerReceiver(this@ZitiServerSocketChannel)

                val connectMsg = Message(ZitiProtocol.ContentType.Bind, session.token.toByteArray(Charsets.UTF_8))
                connectMsg.setHeader(ZitiProtocol.Header.ConnId, connId)
                connectMsg.setHeader(ZitiProtocol.Header.SeqHeader, 0)
                connectMsg.setHeader(ZitiProtocol.Header.PublicKeyHeader, keyPair.publicKey.asBytes)

                d("starting network connection ${session.id}/$connId")
                val reply = channel.SendAndWait(connectMsg)
                when (reply.content) {
                    ZitiProtocol.ContentType.StateConnected -> {
                        d("network connection established ${session.id}/$connId")
                        incoming = Chan(backlog)
                        localAddr = local
                        state = State.bound
                    }
                    ZitiProtocol.ContentType.StateClosed -> {
                        state = State.closed
                        val err = reply.body.toString(Charsets.UTF_8)
                        w("connection rejected: ${err}")
                        channel.deregisterReceiver(connId)
                        throw IOException(err)
                    }
                    else -> {
                        state = State.closed
                        channel.deregisterReceiver(connId)
                        throw IOException("Invalid response type")
                    }
                }
            } catch (ex: Throwable) {
                e("failed to bind", ex)
                state = State.closed
                throw BindException(ex.message)
            }
        }
        return this
    }

    override fun getLocalAddress(): SocketAddress? = localAddr

    override fun <A : Any?> accept(att: A, handler: CompletionHandler<AsynchronousSocketChannel, in A>) {
        if (state == State.closed) throw ClosedChannelException()
        if (state != State.bound) throw NotYetBoundException()

        ctx.async {
            try {
                val req = incoming.receive()

                val child = ZitiSocketChannel(ctx)
                child.connId = channel.registerReceiver(child)
                d{"accepting child conn[${child.connId}] on parent[$connId]"}
                val connIdBuf = ByteArray(4)
                ByteBuffer.wrap(connIdBuf).order(ByteOrder.LITTLE_ENDIAN).putInt(child.connId)
                val dialSuccess = Message(ZitiProtocol.ContentType.DialSuccess, connIdBuf)
                dialSuccess.setHeader(ZitiProtocol.Header.SeqHeader, 0)
                dialSuccess.setHeader(ZitiProtocol.Header.ConnId, connId)
                dialSuccess.setHeader(ZitiProtocol.Header.ReplyFor, req.seqNo)

                val sessKeys = req.getHeader(ZitiProtocol.Header.PublicKeyHeader)?.let {
                    Crypto.kx(keyPair, Key.fromBytes(it), true)
                }
                child.setupCrypto(sessKeys)

                val startMsg = channel.SendAndWait(dialSuccess)

                if (startMsg.content == ZitiProtocol.ContentType.StateConnected) {
                    child.state.set(ZitiSocketChannel.State.connected)
                    child.channel = channel
                    child.startCrypto()
                    child.local = localAddr
                    child.remote = ZitiAddress.Session("$connId", child.connId, localAddr!!.name)

                    handler.completed(child, att)
                } else {
                    val err = Charsets.UTF_8.decode(ByteBuffer.wrap(startMsg.body)).toString()
                    handler.failed(IOException(err), att)
                }
            } catch (clex: ClosedReceiveChannelException) {
                handler.failed(ClosedChannelException(), att)
            }
        }
    }

    override fun accept(): Future<AsynchronousSocketChannel> {
        val result = CompletableFuture<AsynchronousSocketChannel>()
        accept(result, FutureHandler())
        return result
    }

    override fun supportedOptions(): Set<SocketOption<*>> = setOf()
    override fun <T : Any?> setOption(name: SocketOption<T>?, value: T): AsynchronousServerSocketChannel = this
    override fun <T : Any> getOption(name: SocketOption<T>?): T? = null

    override fun close() {
        if (state == State.bound) {
            val unbind = Message(ZitiProtocol.ContentType.Unbind, token.toByteArray(Charsets.UTF_8)).apply {
                setHeader(ZitiProtocol.Header.ConnId, connId)
            }
            runBlocking { channel.SendSynch(unbind) }

            channel.deregisterReceiver(connId)
        }
        state = State.closed
    }

    override suspend fun receive(msg: Message) {
        when(msg.content) {
            ZitiProtocol.ContentType.Dial -> {
                if (!incoming.offer(msg)) { // backlog is full
                    val reject = Message(ZitiProtocol.ContentType.DialFailed)
                        .setHeader(ZitiProtocol.Header.ConnId, connId)
                        .setHeader(ZitiProtocol.Header.ReplyFor, msg.seqNo)
                        .setHeader(ZitiProtocol.Header.SeqHeader, 0)

                    channel.Send(reject)
                }
            }
            ZitiProtocol.ContentType.StateClosed -> {
                incoming.close()
                channel.deregisterReceiver(connId)
                state = State.closed
            }
            else -> {
                e{"unexpected message[${msg.content}] on bound conn[$connId]"}
                incoming.close()
                state = State.closed
                channel.deregisterReceiver(connId)
            }
        }
    }
}