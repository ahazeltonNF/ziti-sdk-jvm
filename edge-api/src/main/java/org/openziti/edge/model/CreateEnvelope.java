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
import java.util.Objects;
import java.util.StringJoiner;

/** CreateEnvelope */
@JsonPropertyOrder({CreateEnvelope.JSON_PROPERTY_DATA, CreateEnvelope.JSON_PROPERTY_META})
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        date = "2024-09-04T10:11:22.635226-04:00[America/New_York]",
        comments = "Generator version: 7.8.0")
public class CreateEnvelope {
    public static final String JSON_PROPERTY_DATA = "data";
    private CreateLocation data;

    public static final String JSON_PROPERTY_META = "meta";
    private Meta meta;

    public CreateEnvelope() {}

    public CreateEnvelope data(CreateLocation data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public CreateLocation getData() {
        return data;
    }

    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setData(CreateLocation data) {
        this.data = data;
    }

    public CreateEnvelope meta(Meta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /** Return true if this createEnvelope object is equal to o. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateEnvelope createEnvelope = (CreateEnvelope) o;
        return Objects.equals(this.data, createEnvelope.data)
                && Objects.equals(this.meta, createEnvelope.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateEnvelope {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

        // add `data` to the URL query string
        if (getData() != null) {
            joiner.add(getData().toUrlQueryString(prefix + "data" + suffix));
        }

        // add `meta` to the URL query string
        if (getMeta() != null) {
            joiner.add(getMeta().toUrlQueryString(prefix + "meta" + suffix));
        }

        return joiner.toString();
    }
}
