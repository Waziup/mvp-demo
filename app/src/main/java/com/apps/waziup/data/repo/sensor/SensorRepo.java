package com.apps.waziup.data.repo.sensor;

import com.apps.waziup.data.repo.domain.local.DomainLocalContract;
import com.apps.waziup.data.repo.domain.remote.DomainRemoteContract;

/**
 * Created by KidusMT on 4/12/2018.
 */

public class SensorRepo {
    private DomainLocalContract local;
    private DomainRemoteContract remote;

    public SensorRepo(DomainLocalContract local, DomainRemoteContract remote) {
        this.local = local;
        this.remote = remote;
    }
}
