package com.apps.waziup.data.repo.sensor.local;

import com.apps.waziup.data.model.Sensor;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public interface SensorLocalContract {

    Observable<List<Sensor>> getSensors();

    Observable<Boolean> deleteSensor(String sensor_id);

    Observable<Boolean> saveSensors(List<Sensor> sensors);

    Observable<Sensor> getSensor(String sensor_id);

//    Observable<> insertOwner();
//
//    Observable<> insertOwner();
//
//    Observable<> insertName();
//
//    Observable<> getMeasurements();
//
//    Observable<> insertNewMeasurement();
//
//    Observable<> getMeasurement();
//
//    Observable<> deleteMeasurement();
//
//    Observable<> putMeasurementUnit();
//
//    Observable<> putMeasurementName();
//
//    Observable<> putQuantityKindFromWaziup();
//
//    Observable<> getMeasurementValues();
//
//    Observable<> createNewDataPoint();

    int size();
}
