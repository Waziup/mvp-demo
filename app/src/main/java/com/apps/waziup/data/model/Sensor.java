package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/1/2018.
 */

import java.util.List;

import com.apps.waziup.data.converter.LocationConverter;
import com.apps.waziup.data.converter.MeasurementListConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.*;
import io.objectbox.annotation.Entity;

@Entity
public class Sensor {

    @Id
    public long _id;

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("gateway_id")
    @Expose
    public String gatewayId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("owner")
    @Expose
    public String owner;
    @SerializedName("location")
    @Expose
    @Convert(converter = LocationConverter.class, dbType = String.class)
    public Location location;
    @SerializedName("dateCreated")
    @Expose
    public String dateCreated;
    @SerializedName("dateModified")
    @Expose
    public String dateModified;
    @SerializedName("domain")
    @Expose
    public String domain;
    @SerializedName("measurements")
    @Expose
    @Convert(converter = MeasurementListConverter.class, dbType = String.class)
    public List<Measurement> measurements = null;

}