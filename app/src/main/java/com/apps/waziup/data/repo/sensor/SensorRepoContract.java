package com.apps.waziup.data.repo.sensor;

import com.apps.waziup.data.model.Sensor;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/12/2018.
 */

public interface SensorRepoContract {

    Observable<List<Sensor>> getAllSensors(String domain, String q, String limit, String offset);

    int size();
}
