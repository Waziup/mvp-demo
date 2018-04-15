package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.*;
import io.objectbox.annotation.Entity;

@Entity
public class Location {

    @Id
    public long _id;

    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
}

