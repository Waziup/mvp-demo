package com.apps.waziup.data.repo.sensor.remote;

import android.content.Context;

import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.data.repo.BaseRemote;
import com.apps.waziup.domain.services.model.Location;
import com.apps.waziup.domain.services.model.Measurement;
import com.apps.waziup.domain.services.model.MeasurementValue;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public class SensorRemote extends BaseRemote implements SensorRemoteContract{

    public SensorRemote(Context context) {
        super(context, "sensor");
    }

    @Override
    public Observable<List<Sensor>> domainsDomainSensorsGet(String domain, String q, String limit, String offset) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsPost(Sensor body, String domain) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdDelete(String domain, String sensorId) {
        return null;
    }

    @Override
    public Observable<Sensor> domainsDomainSensorsSensorIdGet(String domain, String sensorId) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdLocationPut(String domain, String sensorId, Location body) {
        return null;
    }

    @Override
    public Observable<List<Measurement>> domainsDomainSensorsSensorIdMeasurementsGet(String domain, String sensorId) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdDelete(String domain, String sensorId, String measurementId) {
        return null;
    }

    @Override
    public Observable<Measurement> domainsDomainSensorsSensorIdMeasurementsMeasurementIdGet(String domain, String sensorId, String measurementId) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdNamePut(String domain, String sensorId, String measurementId, String body) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdQuantityKindPut(String domain, String sensorId, String measurementId, String body) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdSensingDevicePut(String domain, String sensorId, String measurementId, String body) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdUnitPut(String domain, String sensorId, String measurementId, String body) {
        return null;
    }

    @Override
    public Observable<List<MeasurementValue>> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesGet(String domain, String sensorId, String measurementId, String lastN, String limit, String offset, String dateFrom, String dateTo) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesPost(String domain, String sensorId, String measurementId, MeasurementValue body) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsPost(String domain, String sensorId, Measurement body) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdNamePut(String domain, String sensorId, String body) {
        return null;
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdOwnerPut(String domain, String sensorId, String body) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
