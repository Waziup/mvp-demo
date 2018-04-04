package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("attribute1")
    @Expose
    private String attribute1;
    @SerializedName("attribute2")
    @Expose
    private String attribute2;
//    @SerializedName("attributeN")
//    @Expose
//    private AttributeN attributeN;
//    @SerializedName("additionalProp1")
//    @Expose
//    private AdditionalProp1 additionalProp1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

//    public AttributeN getAttributeN() {
//        return attributeN;
//    }

//    public void setAttributeN(AttributeN attributeN) {
//        this.attributeN = attributeN;
//    }

//    public AdditionalProp1 getAdditionalProp1() {
//        return additionalProp1;
//    }

//    public void setAdditionalProp1(AdditionalProp1 additionalProp1) {
//        this.additionalProp1 = additionalProp1;
//    }

}
