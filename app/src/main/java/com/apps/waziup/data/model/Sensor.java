package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class Sensor {
    public String name;
    public String description;
    public int image;
    public String type;
    public String unit;
    public String position;
    public String latitude;
    public String longitude;
    public String group;
    public String association;
    public String note;
    public String isPublic;

    public Sensor(String name, String description, String type, int image, String position) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.image = image;
        this.position = position;
    }
}
