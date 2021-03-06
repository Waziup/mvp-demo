/*
 * WAZIUP API
 * This API allows you to access all Waziup services. In order to access protected services, first get a token with POST /auth/token. Then insert this token in the authorization key, specifying \"Bearer\" in front. For example \"Bearer: eyJhbGc...\".
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.apps.waziup.domain.services.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An entity is a general object with type and name, implementing different userdefined attributes.
 */
@ApiModel(description = "An entity is a general object with type and name, implementing different userdefined attributes.")

public class EntityWithAttr {
    @SerializedName("id")
    private String id = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("attribute1")
    private List<String> attribute1 = null;

    @SerializedName("attribute2")
    private List<BigDecimal> attribute2 = null;

    @SerializedName("attributeN")
    private List<EntityWithAttrAttributeN> attributeN = null;

    public EntityWithAttr id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Unique name (ID) of the entity.
     *
     * @return id
     **/
    @ApiModelProperty(example = "Barn4", required = true, value = "Unique name (ID) of the entity.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EntityWithAttr type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(required = true, value = "")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EntityWithAttr attribute1(List<String> attribute1) {
        this.attribute1 = attribute1;
        return this;
    }

    public EntityWithAttr addAttribute1Item(String attribute1Item) {
        if (this.attribute1 == null) {
            this.attribute1 = new ArrayList<String>();
        }
        this.attribute1.add(attribute1Item);
        return this;
    }

    /**
     * An example attribute with string values.
     *
     * @return attribute1
     **/
    @ApiModelProperty(value = "An example attribute with string values.")
    public List<String> getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(List<String> attribute1) {
        this.attribute1 = attribute1;
    }

    public EntityWithAttr attribute2(List<BigDecimal> attribute2) {
        this.attribute2 = attribute2;
        return this;
    }

    public EntityWithAttr addAttribute2Item(BigDecimal attribute2Item) {
        if (this.attribute2 == null) {
            this.attribute2 = new ArrayList<BigDecimal>();
        }
        this.attribute2.add(attribute2Item);
        return this;
    }

    /**
     * An example attribute with number values.
     *
     * @return attribute2
     **/
    @ApiModelProperty(value = "An example attribute with number values.")
    public List<BigDecimal> getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(List<BigDecimal> attribute2) {
        this.attribute2 = attribute2;
    }

    public EntityWithAttr attributeN(List<EntityWithAttrAttributeN> attributeN) {
        this.attributeN = attributeN;
        return this;
    }

    public EntityWithAttr addAttributeNItem(EntityWithAttrAttributeN attributeNItem) {
        if (this.attributeN == null) {
            this.attributeN = new ArrayList<EntityWithAttrAttributeN>();
        }
        this.attributeN.add(attributeNItem);
        return this;
    }

    /**
     * An example attribute with object values.
     *
     * @return attributeN
     **/
    @ApiModelProperty(value = "An example attribute with object values.")
    public List<EntityWithAttrAttributeN> getAttributeN() {
        return attributeN;
    }

    public void setAttributeN(List<EntityWithAttrAttributeN> attributeN) {
        this.attributeN = attributeN;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntityWithAttr entityWithAttr = (EntityWithAttr) o;
        return Objects.equals(this.id, entityWithAttr.id) &&
                Objects.equals(this.type, entityWithAttr.type) &&
                Objects.equals(this.attribute1, entityWithAttr.attribute1) &&
                Objects.equals(this.attribute2, entityWithAttr.attribute2) &&
                Objects.equals(this.attributeN, entityWithAttr.attributeN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attribute1, attribute2, attributeN);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityWithAttr {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    attribute1: ").append(toIndentedString(attribute1)).append("\n");
        sb.append("    attribute2: ").append(toIndentedString(attribute2)).append("\n");
        sb.append("    attributeN: ").append(toIndentedString(attributeN)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

