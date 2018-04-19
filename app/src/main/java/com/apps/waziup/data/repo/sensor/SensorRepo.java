package com.apps.waziup.data.repo.sensor;

import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.data.repo.sensor.local.SensorLocalContract;
import com.apps.waziup.data.repo.sensor.remote.SensorRemoteContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/12/2018.
 */

public class SensorRepo implements SensorRepoContract {

    private SensorLocalContract local;
    private SensorRemoteContract remote;

    public SensorRepo(SensorLocalContract local, SensorRemoteContract remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public Observable<List<Sensor>> getAllSensors(String domain, String q, String limit, String offset) {
        if (local.size() == 0) {
            return remote.domainsDomainSensorsGet(domain, q, limit, offset)
                    .flatMap(sensors -> local.saveSensors(sensors))
                    .flatMap(aBoolean -> local.getSensors());
        } else if (local.size() > remote.size()) {
            local.deleteAllSensors();
            return remote.domainsDomainSensorsGet(domain, q, limit, offset)
                    .flatMap(sensors -> local.saveSensors(sensors))
                    .flatMap(aBoolean -> local.getSensors());
        } else {
            return local.getSensors();
        }
    }

    @Override
    public int size() {
        return local.size();
    }
}
