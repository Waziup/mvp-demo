package com.apps.waziup.data.repo.domain;


import com.apps.waziup.data.model.Domain;
import java.util.List;
import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/11/2018.
 */

public interface DomainRepoContract {

    Observable<List<Domain>> getDomains();
    Observable<Void> deleteDomain(String domain);
    Observable<Void> createDomain(Domain domain);
    int size();
}
