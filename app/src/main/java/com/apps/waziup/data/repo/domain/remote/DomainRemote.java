package com.apps.waziup.data.repo.domain.remote;

import android.content.Context;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.repo.BaseRemote;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by KidusMT on 4/4/2018.
 */

public class DomainRemote extends BaseRemote implements DomainRemoteContract {

    public DomainRemote(Context context) {
        super(context, "domain");
    }

    @Override
    public Observable<Void> createDomain(Domain domain) {
        return BaseRemote.domainService.createDomain(domain);
    }

    @Override
    public Observable<Void> deleteDomain(String domain) {
        return BaseRemote.domainService.deleteDomain(domain);
    }

    @Override
    public Observable<List<Domain>> getDomains() {
        return BaseRemote.domainService.getDomains();
    }

    @Override
    public int size() {
        return BaseRemote.domainService.getDomains()
                .subscribeOn(Schedulers.computation())
                .blockingSingle()
                .size();
    }
}
