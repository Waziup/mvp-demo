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

    @GET("/api/v1/domains/{domain}/sensors")
    Observable<Sensor> getSensorData(@Path("domain") String domain);

    @Headers("Content-Type: application/json")
    @POST("/api/v1/domains/{domain}/sensors")
    Observable<String> createSensor(@Path("domain") String domain, @Body Sensor sensor);



}
