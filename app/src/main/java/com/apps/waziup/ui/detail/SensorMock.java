package com.apps.waziup.ui.detail;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class SensorMock {
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

    public SensorMock(String name, String description, String type, int image, String position) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.image = image;
        this.position = position;
    }
}
