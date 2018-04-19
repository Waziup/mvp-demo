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

public class SensorRemote extends BaseRemote implements SensorRemoteContract {


    public SensorRemote(Context context) {
        super(context, "sensor");
    }

    @Override
    public Observable<List<Sensor>> domainsDomainSensorsGet(String domain, String q, String limit, String offset) {
        return BaseRemote.sensorService.domainsDomainSensorsGet(domain);
    }

    @Override
    public Observable<Void> domainsDomainSensorsPost(Sensor body, String domain) {
        return BaseRemote.sensorService.domainsDomainSensorsPost(body, domain);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdDelete(String domain, String sensorId) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdDelete(domain, sensorId);
    }

    @Override
    public Observable<Sensor> domainsDomainSensorsSensorIdGet(String domain, String sensorId) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdGet(domain,sensorId);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdLocationPut(String domain, String sensorId, Location body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdLocationPut(domain, sensorId, body);
    }

    @Override
    public Observable<List<Measurement>> domainsDomainSensorsSensorIdMeasurementsGet(String domain, String sensorId) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsGet(domain, sensorId);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdDelete(String domain, String sensorId, String measurementId) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdDelete(domain, sensorId, measurementId);
    }

    @Override
    public Observable<Measurement> domainsDomainSensorsSensorIdMeasurementsMeasurementIdGet(String domain, String sensorId, String measurementId) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdGet(domain, sensorId, measurementId);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdNamePut(String domain, String sensorId, String measurementId, String body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdNamePut(domain, sensorId, measurementId, body);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdQuantityKindPut(String domain, String sensorId, String measurementId, String body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdQuantityKindPut(domain, sensorId, measurementId, body);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdSensingDevicePut(String domain, String sensorId, String measurementId, String body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdSensingDevicePut(domain, sensorId, measurementId, body);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdUnitPut(String domain, String sensorId, String measurementId, String body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdUnitPut(domain, sensorId, measurementId, body);
    }

    @Override
    public Observable<List<MeasurementValue>> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesGet(String domain, String sensorId, String measurementId, String lastN, String limit, String offset, String dateFrom, String dateTo) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesGet(domain, sensorId, measurementId, lastN, limit, offset, dateFrom, dateTo);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesPost(String domain, String sensorId, String measurementId, MeasurementValue body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesPost(domain, sensorId, measurementId, body);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdMeasurementsPost(String domain, String sensorId, Measurement body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdMeasurementsPost(domain, sensorId, body);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdNamePut(String domain, String sensorId, String body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdNamePut(domain, sensorId, body);
    }

    @Override
    public Observable<Void> domainsDomainSensorsSensorIdOwnerPut(String domain, String sensorId, String body) {
        return BaseRemote.sensorService.domainsDomainSensorsSensorIdOwnerPut(domain, sensorId, body);
    }

    @Override
    public int size() {
        //TODO should be changed to get the number of available sensors on remote
        return 0;
    }
}
