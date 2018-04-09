package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measurement {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_value")
    @Expose
    private Integer lastValue;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("sensing_device")
    @Expose
    private String sensingDevice;
    @SerializedName("quantity_kind")
    @Expose
    private String quantityKind;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("values")
    @Expose
    private List<Value> values = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLastValue() {
        return lastValue;
    }

    public void setLastValue(Integer lastValue) {
        this.lastValue = lastValue;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

}
