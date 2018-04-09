package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datapoint {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
