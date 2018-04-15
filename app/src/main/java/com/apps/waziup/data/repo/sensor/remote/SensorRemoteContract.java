package com.apps.waziup.data.repo.sensor.remote;

import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.domain.services.model.Location;
import com.apps.waziup.domain.services.model.Measurement;
import com.apps.waziup.domain.services.model.MeasurementValue;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public interface SensorRemoteContract {


    /**
     * Sensor data
     *
     * @param domain (required)
     * @param q      filter the results (optional)
     * @param limit  In case of pagination, number of entris per page (optional)
     * @param offset In case of pagination, offset for the starting entry (optional)
     * @return Call&lt;List&lt;Sensor&gt;&gt;
     */
    Observable<List<Sensor>> domainsDomainSensorsGet(
            String domain,
            String q,
            String limit,
            String offset
    );

    /**
     * Create sensors
     *
     * @param body   (required)
     * @param domain (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsPost(
            Sensor body,
            String domain
    );

    /**
     * Delete sensor
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdDelete(
            String domain,
            String sensorId
    );

    /**
     * get sensor
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @return Call&lt;Sensor&gt;
     */
    Observable<Sensor> domainsDomainSensorsSensorIdGet(
            String domain,
            String sensorId
    );

    /**
     * insert location
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdLocationPut(
            String domain,
            String sensorId,
            Location body
    );

    /**
     * get measurements
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @return Call&lt;List&lt;Measurement&gt;&gt;
     */
    Observable<List<Measurement>> domainsDomainSensorsSensorIdMeasurementsGet(
            String domain,
            String sensorId
    );

    /**
     * Delete measurement
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdDelete(
            String domain,
            String sensorId,
            String measurementId
    );

    /**
     * get measurement
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @return Call&lt;Measurement&gt;
     */
    Observable<Measurement> domainsDomainSensorsSensorIdMeasurementsMeasurementIdGet(
            String domain,
            String sensorId,
            String measurementId
    );

    /**
     * put measurement name
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @param body          (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdNamePut(
            String domain,
            String sensorId,
            String measurementId,
            String body
    );

    /**
     * put the quantity kind, from https://github.com/Waziup/waziup-js/blob/master/src/model/QuantityKinds.js
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @param body          (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdQuantityKindPut(
            String domain,
            String sensorId,
            String measurementId,
            String body
    );

    /**
     * insert sensing device used to perform the measurement, from https://github.com/Waziup/waziup-js/blob/master/src/model/SensingDevices.js
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @param body          (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdSensingDevicePut(
            String domain,
            String sensorId,
            String measurementId,
            String body
    );

    /**
     * put measurement unit
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @param body          (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdUnitPut(
            String domain,
            String sensorId,
            String measurementId,
            String body
    );

    /**
     * get measurement values
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @param lastN         get the last N entries, most recent first. Default value is 20. (optional)
     * @param limit         In case of pagination, number of entris per page (optional)
     * @param offset        In case of pagination, offset for the starting entry (optional)
     * @param dateFrom      The starting date and time from which the entries are desired. It is an optional parameter. (optional)
     * @param dateTo        The final date and time until which the entries are desired. It is an optional parameter. (optional)
     * @return Call&lt;List&lt;MeasurementValue&gt;&gt;
     */
    Observable<List<MeasurementValue>> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesGet(
            String domain,
            String sensorId,
            String measurementId,
            String lastN,
            String limit,
            String offset,
            String dateFrom,
            String dateTo
    );

    /**
     * Create new datapoint
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @param body          (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesPost( String domain,
                                                                                      String sensorId,
                                                                                      String measurementId,
                                                                                      MeasurementValue body
    );

    /**
     * insert new measurement
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsPost( String domain, String sensorId,
                                                                   Measurement body
    );

    /**
     * insert name
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdNamePut( String domain, String sensorId, String body);

    /**
     * insert owner
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    Observable<Void> domainsDomainSensorsSensorIdOwnerPut( String domain, String sensorId, String body);

    int size();
}
