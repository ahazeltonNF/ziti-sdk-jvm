/*
 * Ziti Edge Client
 * OpenZiti Edge Client API
 *
 * The version of the OpenAPI document: 0.26.27
 * Contact: help@openziti.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openziti.edge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import org.openziti.edge.ApiClient;

/** A singular authenticator resource */
@JsonPropertyOrder({
    AuthenticatorDetail.JSON_PROPERTY_LINKS,
    AuthenticatorDetail.JSON_PROPERTY_CREATED_AT,
    AuthenticatorDetail.JSON_PROPERTY_ID,
    AuthenticatorDetail.JSON_PROPERTY_TAGS,
    AuthenticatorDetail.JSON_PROPERTY_UPDATED_AT,
    AuthenticatorDetail.JSON_PROPERTY_CERT_PEM,
    AuthenticatorDetail.JSON_PROPERTY_FINGERPRINT,
    AuthenticatorDetail.JSON_PROPERTY_IDENTITY,
    AuthenticatorDetail.JSON_PROPERTY_IDENTITY_ID,
    AuthenticatorDetail.JSON_PROPERTY_IS_ISSUED_BY_NETWORK,
    AuthenticatorDetail.JSON_PROPERTY_METHOD,
    AuthenticatorDetail.JSON_PROPERTY_USERNAME
})
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        date = "2024-09-04T10:11:22.635226-04:00[America/New_York]",
        comments = "Generator version: 7.8.0")
public class AuthenticatorDetail {
    public static final String JSON_PROPERTY_LINKS = "_links";
    private Map<String, Link> links = new HashMap<>();

    public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private Tags tags;

    public static final String JSON_PROPERTY_UPDATED_AT = "updatedAt";
    private OffsetDateTime updatedAt;

    public static final String JSON_PROPERTY_CERT_PEM = "certPem";
    private String certPem;

    public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
    private String fingerprint;

    public static final String JSON_PROPERTY_IDENTITY = "identity";
    private EntityRef identity;

    public static final String JSON_PROPERTY_IDENTITY_ID = "identityId";
    private String identityId;

    public static final String JSON_PROPERTY_IS_ISSUED_BY_NETWORK = "isIssuedByNetwork";
    private Boolean isIssuedByNetwork;

    public static final String JSON_PROPERTY_METHOD = "method";
    private String method;

    public static final String JSON_PROPERTY_USERNAME = "username";
    private String username;

    public AuthenticatorDetail() {}

    public AuthenticatorDetail links(Map<String, Link> links) {
        this.links = links;
        return this;
    }

    public AuthenticatorDetail putLinksItem(String key, Link linksItem) {
        if (this.links == null) {
            this.links = new HashMap<>();
        }
        this.links.put(key, linksItem);
        return this;
    }

    /**
     * A map of named links
     *
     * @return links
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Map<String, Link> getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }

    public AuthenticatorDetail createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AuthenticatorDetail id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(String id) {
        this.id = id;
    }

    public AuthenticatorDetail tags(Tags tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Tags getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public AuthenticatorDetail updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AuthenticatorDetail certPem(String certPem) {
        this.certPem = certPem;
        return this;
    }

    /**
     * Get certPem
     *
     * @return certPem
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CERT_PEM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCertPem() {
        return certPem;
    }

    @JsonProperty(JSON_PROPERTY_CERT_PEM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertPem(String certPem) {
        this.certPem = certPem;
    }

    public AuthenticatorDetail fingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    /**
     * Get fingerprint
     *
     * @return fingerprint
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FINGERPRINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getFingerprint() {
        return fingerprint;
    }

    @JsonProperty(JSON_PROPERTY_FINGERPRINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public AuthenticatorDetail identity(EntityRef identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get identity
     *
     * @return identity
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_IDENTITY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public EntityRef getIdentity() {
        return identity;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setIdentity(EntityRef identity) {
        this.identity = identity;
    }

    public AuthenticatorDetail identityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    /**
     * Get identityId
     *
     * @return identityId
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_IDENTITY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getIdentityId() {
        return identityId;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public AuthenticatorDetail isIssuedByNetwork(Boolean isIssuedByNetwork) {
        this.isIssuedByNetwork = isIssuedByNetwork;
        return this;
    }

    /**
     * Get isIssuedByNetwork
     *
     * @return isIssuedByNetwork
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_ISSUED_BY_NETWORK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getIsIssuedByNetwork() {
        return isIssuedByNetwork;
    }

    @JsonProperty(JSON_PROPERTY_IS_ISSUED_BY_NETWORK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsIssuedByNetwork(Boolean isIssuedByNetwork) {
        this.isIssuedByNetwork = isIssuedByNetwork;
    }

    public AuthenticatorDetail method(String method) {
        this.method = method;
        return this;
    }

    /**
     * Get method
     *
     * @return method
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_METHOD)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getMethod() {
        return method;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMethod(String method) {
        this.method = method;
    }

    public AuthenticatorDetail username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getUsername() {
        return username;
    }

    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsername(String username) {
        this.username = username;
    }

    /** Return true if this authenticatorDetail object is equal to o. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticatorDetail authenticatorDetail = (AuthenticatorDetail) o;
        return Objects.equals(this.links, authenticatorDetail.links)
                && Objects.equals(this.createdAt, authenticatorDetail.createdAt)
                && Objects.equals(this.id, authenticatorDetail.id)
                && Objects.equals(this.tags, authenticatorDetail.tags)
                && Objects.equals(this.updatedAt, authenticatorDetail.updatedAt)
                && Objects.equals(this.certPem, authenticatorDetail.certPem)
                && Objects.equals(this.fingerprint, authenticatorDetail.fingerprint)
                && Objects.equals(this.identity, authenticatorDetail.identity)
                && Objects.equals(this.identityId, authenticatorDetail.identityId)
                && Objects.equals(this.isIssuedByNetwork, authenticatorDetail.isIssuedByNetwork)
                && Objects.equals(this.method, authenticatorDetail.method)
                && Objects.equals(this.username, authenticatorDetail.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                links,
                createdAt,
                id,
                tags,
                updatedAt,
                certPem,
                fingerprint,
                identity,
                identityId,
                isIssuedByNetwork,
                method,
                username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticatorDetail {\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    certPem: ").append(toIndentedString(certPem)).append("\n");
        sb.append("    fingerprint: ").append(toIndentedString(fingerprint)).append("\n");
        sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
        sb.append("    identityId: ").append(toIndentedString(identityId)).append("\n");
        sb.append("    isIssuedByNetwork: ")
                .append(toIndentedString(isIssuedByNetwork))
                .append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Convert the instance into URL query string.
     *
     * @return URL query string
     */
    public String toUrlQueryString() {
        return toUrlQueryString(null);
    }

    /**
     * Convert the instance into URL query string.
     *
     * @param prefix prefix of the query string
     * @return URL query string
     */
    public String toUrlQueryString(String prefix) {
        String suffix = "";
        String containerSuffix = "";
        String containerPrefix = "";
        if (prefix == null) {
            // style=form, explode=true, e.g. /pet?name=cat&type=manx
            prefix = "";
        } else {
            // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
            prefix = prefix + "[";
            suffix = "]";
            containerSuffix = "]";
            containerPrefix = "[";
        }

        StringJoiner joiner = new StringJoiner("&");

        // add `_links` to the URL query string
        if (getLinks() != null) {
            for (String _key : getLinks().keySet()) {
                if (getLinks().get(_key) != null) {
                    joiner.add(
                            getLinks()
                                    .get(_key)
                                    .toUrlQueryString(
                                            String.format(
                                                    "%s_links%s%s",
                                                    prefix,
                                                    suffix,
                                                    "".equals(suffix)
                                                            ? ""
                                                            : String.format(
                                                                    "%s%d%s",
                                                                    containerPrefix,
                                                                    _key,
                                                                    containerSuffix))));
                }
            }
        }

        // add `createdAt` to the URL query string
        if (getCreatedAt() != null) {
            joiner.add(
                    String.format(
                            "%screatedAt%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getCreatedAt()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `id` to the URL query string
        if (getId() != null) {
            joiner.add(
                    String.format(
                            "%sid%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getId()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `tags` to the URL query string
        if (getTags() != null) {
            joiner.add(getTags().toUrlQueryString(prefix + "tags" + suffix));
        }

        // add `updatedAt` to the URL query string
        if (getUpdatedAt() != null) {
            joiner.add(
                    String.format(
                            "%supdatedAt%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getUpdatedAt()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `certPem` to the URL query string
        if (getCertPem() != null) {
            joiner.add(
                    String.format(
                            "%scertPem%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getCertPem()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `fingerprint` to the URL query string
        if (getFingerprint() != null) {
            joiner.add(
                    String.format(
                            "%sfingerprint%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getFingerprint()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `identity` to the URL query string
        if (getIdentity() != null) {
            joiner.add(getIdentity().toUrlQueryString(prefix + "identity" + suffix));
        }

        // add `identityId` to the URL query string
        if (getIdentityId() != null) {
            joiner.add(
                    String.format(
                            "%sidentityId%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getIdentityId()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `isIssuedByNetwork` to the URL query string
        if (getIsIssuedByNetwork() != null) {
            joiner.add(
                    String.format(
                            "%sisIssuedByNetwork%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getIsIssuedByNetwork()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `method` to the URL query string
        if (getMethod() != null) {
            joiner.add(
                    String.format(
                            "%smethod%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getMethod()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        // add `username` to the URL query string
        if (getUsername() != null) {
            joiner.add(
                    String.format(
                            "%susername%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getUsername()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        return joiner.toString();
    }
}
