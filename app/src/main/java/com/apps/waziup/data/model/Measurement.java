package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measurement {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("last_value")
    @Expose
    private Double lastValue;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sensing_device")
    @Expose
    private String sensingDevice;
    @SerializedName("quantity_kind")
    @Expose
    private String quantityKind;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLastValue() {
        return lastValue;
    }

    public void setLastValue(Double lastValue) {
        this.lastValue = lastValue;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSensingDevice() {
        return sensingDevice;
    }

    public void setSensingDevice(String sensingDevice) {
        this.sensingDevice = sensingDevice;
    }

    public String getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}