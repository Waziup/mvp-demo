package com.apps.waziup.data.repo.sensor;

import com.apps.waziup.data.repo.domain.local.DomainLocalContract;
import com.apps.waziup.data.repo.domain.remote.DomainRemoteContract;
import com.apps.waziup.data.repo.sensor.local.SensorLocalContract;
import com.apps.waziup.data.repo.sensor.remote.SensorRemoteContract;

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
    public int size() {
        return local.size();
    }
}
