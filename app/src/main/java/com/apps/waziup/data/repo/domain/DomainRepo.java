package com.apps.waziup.data.repo.domain;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.repo.domain.local.DomainLocalContract;
import com.apps.waziup.data.repo.domain.remote.DomainRemoteContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/11/2018.
 */

public class DomainRepo implements DomainRepoContract {


    private DomainLocalContract local;
    private DomainRemoteContract remote;

    public DomainRepo(DomainLocalContract local, DomainRemoteContract remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public Observable<List<Domain>> getDomains() {
        if (local.size() == 0) {
            return remote.getDomains()
                    .flatMap(domains -> local.saveDomain(domains))
                    .flatMap(aBoolean -> local.getDomains());
        } else {
            return local.getDomains();
        }
    }

    @Override
    public Observable<Void> deleteDomain(String domain) {
        return remote.deleteDomain(domain);
    }

    @Override
    public Observable<Void> createDomain(Domain domain) {
        return remote.createDomain(domain);
    }

    @Override
    public int size() {
        return local.size();
    }
}
