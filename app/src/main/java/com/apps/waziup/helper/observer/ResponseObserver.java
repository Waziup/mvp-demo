package com.apps.waziup.helper.observer;

import retrofit.client.Response;
import rx.Observer;

public abstract class ResponseObserver implements Observer<Response> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        error(e);
    }

    @Override
    public void onNext(Response o) {
        next(o.getStatus());
    }

    public abstract void error(Throwable e);

    public abstract void next(int status);
}
