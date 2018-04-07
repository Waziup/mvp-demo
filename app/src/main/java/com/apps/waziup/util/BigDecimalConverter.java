package com.apps.waziup.util;

import java.math.BigDecimal;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by askia on 4/7/2018.
 */

public class BigDecimalConverter implements PropertyConverter<BigDecimal, String> {

    @Override
    public BigDecimal convertToEntityProperty(String databaseValue) {
        return new BigDecimal(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(BigDecimal entityProperty) {
        return entityProperty.toString();
    }
}
