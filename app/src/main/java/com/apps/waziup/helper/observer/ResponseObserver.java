package com.apps.waziup.helper.observer;

import io.reactivex.Observer;
import retrofit2.Response;

public abstract class ResponseObserver implements Observer<Response> {
    //@Override

    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        error(e);
    }

    @Override
    public void onNext(Response o) {
        next(o.code());
    }

    public abstract void error(Throwable e);

    public abstract void next(int status);
}
