/*
 * WAZIUP API
 * This API allows you to access all Waziup services. In order to access protected services, first get a token with POST /auth/token. Then insert this token in the authorization key, specifying \"Bearer\" in front. For example \"Bearer: eyJhbGc...\".
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.apps.waziup.domain.services.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Measurement
 */

public class Measurement {
    @SerializedName("id")
    private String id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("timestamp")
    private String timestamp = null;

    @SerializedName("sensing_device")
    private String sensingDevice = null;

    @SerializedName("quantity_kind")
    private String quantityKind = null;

    @SerializedName("unit")
    private String unit = null;

    @SerializedName("values")
    private List<MeasurementValue> values = null;

    public Measurement id(String id) {
        this.id = id;
        return this;
    }

    /**
     * ID of the measurement
     *
     * @return id
     **/
    @ApiModelProperty(example = "TC1", value = "ID of the measurement")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Measurement name(String name) {
        this.name = name;
        return this;
    }

    /**
     * name of the measurement
     *
     * @return name
     **/
    @ApiModelProperty(example = "My garden temperature", value = "name of the measurement")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measurement timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * time of the last measurement
     *
     * @return timestamp
     **/
    @ApiModelProperty(example = "2016-06-08T18:20:27.873Z", value = "time of the last measurement")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Measurement sensingDevice(String sensingDevice) {
        this.sensingDevice = sensingDevice;
        return this;
    }

    /**
     * sensing platform used for the measurement, from https://github.com/Waziup/waziup-js/blob/master/src/model/SensingDevices.js
     *
     * @return sensingDevice
     **/
    @ApiModelProperty(example = "SoilThermometer", value = "sensing platform used for the measurement, from https://github.com/Waziup/waziup-js/blob/master/src/model/SensingDevices.js")
    public String getSensingDevice() {
        return sensingDevice;
    }

    public void setSensingDevice(String sensingDevice) {
        this.sensingDevice = sensingDevice;
    }

    public Measurement quantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
        return this;
    }

    /**
     * quantity measured, from https://github.com/Waziup/waziup-js/blob/master/src/model/QuantityKinds.js
     *
     * @return quantityKind
     **/
    @ApiModelProperty(example = "SoilTemperature", value = "quantity measured, from https://github.com/Waziup/waziup-js/blob/master/src/model/QuantityKinds.js")
    public String getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
    }

    public Measurement unit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * unit of the measurement, from https://github.com/Waziup/waziup-js/blob/master/src/model/Units.js
     *
     * @return unit
     **/
    @ApiModelProperty(example = "DegreeCelsius", value = "unit of the measurement, from https://github.com/Waziup/waziup-js/blob/master/src/model/Units.js")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Measurement values(List<MeasurementValue> values) {
        this.values = values;
        return this;
    }

    public Measurement addValuesItem(MeasurementValue valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<MeasurementValue>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * Get values
     *
     * @return values
     **/
    @ApiModelProperty(value = "")
    public List<MeasurementValue> getValues() {
        return values;
    }

    public void setValues(List<MeasurementValue> values) {
        this.values = values;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Measurement measurement = (Measurement) o;
        return Objects.equals(this.id, measurement.id) &&
                Objects.equals(this.name, measurement.name) &&
                Objects.equals(this.timestamp, measurement.timestamp) &&
                Objects.equals(this.sensingDevice, measurement.sensingDevice) &&
                Objects.equals(this.quantityKind, measurement.quantityKind) &&
                Objects.equals(this.unit, measurement.unit) &&
                Objects.equals(this.values, measurement.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, timestamp, sensingDevice, quantityKind, unit, values);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Measurement {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    sensingDevice: ").append(toIndentedString(sensingDevice)).append("\n");
        sb.append("    quantityKind: ").append(toIndentedString(quantityKind)).append("\n");
        sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

