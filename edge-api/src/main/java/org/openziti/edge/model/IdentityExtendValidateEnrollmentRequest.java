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
import java.util.Objects;
import java.util.StringJoiner;
import org.openziti.edge.ApiClient;

/** IdentityExtendValidateEnrollmentRequest */
@JsonPropertyOrder({IdentityExtendValidateEnrollmentRequest.JSON_PROPERTY_CLIENT_CERT})
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        date = "2024-09-04T10:11:22.635226-04:00[America/New_York]",
        comments = "Generator version: 7.8.0")
public class IdentityExtendValidateEnrollmentRequest {
    public static final String JSON_PROPERTY_CLIENT_CERT = "clientCert";
    private String clientCert;

    public IdentityExtendValidateEnrollmentRequest() {}

    public IdentityExtendValidateEnrollmentRequest clientCert(String clientCert) {
        this.clientCert = clientCert;
        return this;
    }

    /**
     * A PEM encoded client certificate previously returned after an extension request
     *
     * @return clientCert
     */
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CLIENT_CERT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getClientCert() {
        return clientCert;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_CERT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setClientCert(String clientCert) {
        this.clientCert = clientCert;
    }

    /** Return true if this identityExtendValidateEnrollmentRequest object is equal to o. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentityExtendValidateEnrollmentRequest identityExtendValidateEnrollmentRequest =
                (IdentityExtendValidateEnrollmentRequest) o;
        return Objects.equals(this.clientCert, identityExtendValidateEnrollmentRequest.clientCert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientCert);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdentityExtendValidateEnrollmentRequest {\n");
        sb.append("    clientCert: ").append(toIndentedString(clientCert)).append("\n");
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

        // add `clientCert` to the URL query string
        if (getClientCert() != null) {
            joiner.add(
                    String.format(
                            "%sclientCert%s=%s",
                            prefix,
                            suffix,
                            URLEncoder.encode(
                                            ApiClient.valueToString(getClientCert()),
                                            StandardCharsets.UTF_8)
                                    .replaceAll("\\+", "%20")));
        }

        return joiner.toString();
    }
}
