package com.apps.waziup.domain.services.api;


//import com.apps.waziup.data.model.Sensor;

import com.apps.waziup.domain.services.model.Location;
import com.apps.waziup.domain.services.model.Measurement;
import com.apps.waziup.domain.services.model.MeasurementValue;
import com.apps.waziup.domain.services.model.Sensor;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface SensorsApi {
    /**
     * Sensor data
     *
     * @param domain (required)
     * @param q      filter the results (optional)
     * @param limit  In case of pagination, number of entris per page (optional)
     * @param offset In case of pagination, offset for the starting entry (optional)
     * @return Call&lt;List&lt;Sensor&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/sensors")
    Observable<List<Sensor>> domainsDomainSensorsGet(
            @Path("domain") String domain, @Query("q") String q, @Query("limit") String limit, @Query("offset") String offset
    );

    /**
     * Create sensors
     * Endpoint to create sensing devices.
     *
     * @param body   (required)
     * @param domain (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/sensors")
    Single<Response<Void>> domainsDomainSensorsPost(
            @Body Sensor body, @Path("domain") String domain
    );

    /**
     * Delete sensor
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/sensors/{sensor_id}")
    Single<Response<Void>> domainsDomainSensorsSensorIdDelete(
            @Path("domain") String domain, @Path("sensor_id") String sensorId
    );

    /**
     * get sensor
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @return Call&lt;Sensor&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/sensors/{sensor_id}")
    Single<Sensor> domainsDomainSensorsSensorIdGet(
            @Path("domain") String domain, @Path("sensor_id") String sensorId
    );

    /**
     * insert location
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/location")
    Single<Response<Void>> domainsDomainSensorsSensorIdLocationPut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Body Location body
    );

    /**
     * get measurements
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @return Call&lt;List&lt;Measurement&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/sensors/{sensor_id}/measurements")
    Observable<List<Measurement>> domainsDomainSensorsSensorIdMeasurementsGet(
            @Path("domain") String domain, @Path("sensor_id") String sensorId
    );

    /**
     * Delete measurement
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}")
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdDelete(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId
    );

    /**
     * get measurement
     *
     * @param domain        (required)
     * @param sensorId      (required)
     * @param measurementId (required)
     * @return Call&lt;Measurement&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}")
    Observable<Measurement> domainsDomainSensorsSensorIdMeasurementsMeasurementIdGet(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId
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
    @Headers({
            "Content-Type:text/plain"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}/name")
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdNamePut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId, @Body String body
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
    @Headers({
            "Content-Type:text/plain"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}/quantity_kind")
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdQuantityKindPut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId, @Body String body
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
    @Headers({
            "Content-Type:text/plain"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}/sensing_device")
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdSensingDevicePut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId, @Body String body
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
    @Headers({
            "Content-Type:text/plain"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}/unit")
    Observable<Void> domainsDomainSensorsSensorIdMeasurementsMeasurementIdUnitPut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId, @Body String body
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
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}/values")
    Observable<List<MeasurementValue>> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesGet(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId, @Query("lastN") String lastN, @Query("limit") String limit, @Query("offset") String offset, @Query("dateFrom") String dateFrom, @Query("dateTo") String dateTo
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
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/sensors/{sensor_id}/measurements/{measurement_id}/values")
    Single<Response<Void>> domainsDomainSensorsSensorIdMeasurementsMeasurementIdValuesPost(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Path("measurement_id") String measurementId, @Body MeasurementValue body
    );

    /**
     * insert new measurement
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/sensors/{sensor_id}/measurements")
    Single<Response<Void>> domainsDomainSensorsSensorIdMeasurementsPost(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Body Measurement body
    );

    /**
     * insert name
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:text/plain"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/name")
    Single<Response<Void>> domainsDomainSensorsSensorIdNamePut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Body String body
    );

    /**
     * insert owner
     *
     * @param domain   (required)
     * @param sensorId (required)
     * @param body     (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:text/plain"
    })
    @PUT("domains/{domain}/sensors/{sensor_id}/owner")
    Single<Response<Void>> domainsDomainSensorsSensorIdOwnerPut(
            @Path("domain") String domain, @Path("sensor_id") String sensorId, @Body String body
    );

}
