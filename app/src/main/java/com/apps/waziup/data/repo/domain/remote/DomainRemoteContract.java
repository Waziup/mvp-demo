package com.apps.waziup.data.repo.domain.remote;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.model.DomainResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public interface DomainRemoteContract {

    Observable<DomainResponse> createDomain(Domain domain);

    Observable<List<Domain>> getDomains();
}
