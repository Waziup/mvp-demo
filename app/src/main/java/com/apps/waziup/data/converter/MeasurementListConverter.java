package com.apps.waziup.data.converter;

import com.apps.waziup.data.model.Measurement;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by KidusMT on 4/13/2018.
 */

public class MeasurementListConverter implements PropertyConverter<List<Measurement>, String> {

    private Gson gson;

    public MeasurementListConverter() {
        gson = new Gson();
    }

    @Override
    public List<Measurement> convertToEntityProperty(String databaseValue) {
        if(databaseValue == null) return null;
        JsonParser parser = new JsonParser();
        JsonArray measurementsJsonArray = (JsonArray) parser.parse(databaseValue);
        List<Measurement> measurements = new ArrayList<>();
        for(JsonElement element : measurementsJsonArray) {
            measurements.add(gson.fromJson(element, Measurement.class));
        }
        return measurements;
    }

    @Override
    public String convertToDatabaseValue(List<Measurement> entityProperty) {
        if(entityProperty == null) return null;
        return gson.toJson(entityProperty);
    }
}
