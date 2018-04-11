package com.apps.waziup.data.repo.domain.remote;

import android.content.Context;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.repo.BaseRemote;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/4/2018.
 */

public class DomainRemote extends BaseRemote implements DomainRemoteContract {

    public DomainRemote(Context context) {
        super(context, "user");
    }

    @Override
    public Observable<String> createDomain(Domain domain) {
        return BaseRemote.domainService.createDomain(domain);
    }

    @Override
    public Observable<List<Domain>> getDomains() {
        return BaseRemote.domainService.getDomains();
    }
}
