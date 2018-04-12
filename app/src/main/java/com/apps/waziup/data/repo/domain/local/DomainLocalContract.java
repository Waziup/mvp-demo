package com.apps.waziup.data.repo.domain.local;

import com.apps.waziup.data.model.Domain;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public interface DomainLocalContract {

    Observable<Boolean> saveDomain(List<Domain> domain);

    Observable<List<Domain>> getDomains();

    Observable<Boolean> deleteDomain(Domain domain);

    Observable<Boolean> updateDomain(Domain domain);

    int size();
}
