package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoricalValue {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("attribute_id")
    @Expose
    private String attributeId;
    @SerializedName("datapoint")
    @Expose
    private Datapoint datapoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public Datapoint getDatapoint() {
        return datapoint;
    }

    public void setDatapoint(Datapoint datapoint) {
        this.datapoint = datapoint;
    }

}
