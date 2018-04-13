package com.apps.waziup.data.converter;

import com.apps.waziup.data.model.Location;
import com.google.gson.Gson;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by KidusMT on 4/13/2018.
 */

public class LocationConverter implements PropertyConverter<Location, String> {

    private Gson gson;

    public LocationConverter() {
        gson = new Gson();
    }

    @Override
    public Location convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) return null;
        return gson.fromJson(databaseValue, Location.class);
    }

    @Override
    public String convertToDatabaseValue(Location entityProperty) {
        return gson.toJson(entityProperty);
    }
}
