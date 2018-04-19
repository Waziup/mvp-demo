package com.apps.waziup.data.repo.sensor.local;

import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.data.model.Sensor_;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public class SensorLocal implements SensorLocalContract{

    private Box<Sensor> box;

    public SensorLocal(BoxStore store) {
        box = store.boxFor(Sensor.class);
    }

    @Override
    public Observable<List<Sensor>> getSensors() {
        List<Sensor> sensors = box.getAll();
        return Observable.just(sensors);
    }

    @Override
    public Observable<Boolean> deleteSensor(String sensor_id) {
        Sensor found = box.query().equal(Sensor_.id, sensor_id).build().findFirst();
        if (found == null) {
            return Observable.just(false);
        } else {
            box.remove(found._id);
            return Observable.just(true);
        }
    }

    @Override
    public Observable<Boolean> deleteAllSensors() {
        box.removeAll();
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> saveSensors(List<Sensor> sensors) {
        for (int i = 0; i < sensors.size(); i++) {
            Sensor newSensor = sensors.get(i);
            Sensor found = box.query().equal(Sensor_.id, newSensor.id).build().findFirst();
            if (found == null) {
                box.put(newSensor);
            } else {
                newSensor._id = found._id;
                box.put(newSensor);
            }
        }
        return Observable.just(true);
    }

    @Override
    public Observable<Sensor> getSensor(String sensor_id) {
        Sensor found = box.query().equal(Sensor_.id, sensor_id).build().findFirst();
        if (found!=null){//if found
            return Observable.just(found);
        }else{//if not found
            return null;
        }
    }

    @Override
    public int size() {
        return box.getAll().size();
    }
}
