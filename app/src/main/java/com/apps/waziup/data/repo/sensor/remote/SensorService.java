package com.apps.waziup.data.repo.sensor.remote;

import com.apps.waziup.data.model.Sensor;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by KidusMT on 4/4/2018.
 */

public interface SensorService {

    /**
     * for getting the sensor data of a specific domain
     * @param domain
     * @return
     */
    @GET("/api/v1/domains/{domain}/sensors")
    Observable<Sensor> getSensorData(@Path("domain") String domain);

    /**
     * for creating a sensor on specific domain which have been created previously
     * @param domain
     * @param sensor
     * @return
     */
    @Headers("Content-Type: application/json")
    @POST("/api/v1/domains/{domain}/sensors")
    Observable<String> createSensor(@Path("domain") String domain, @Body Sensor sensor);

}
