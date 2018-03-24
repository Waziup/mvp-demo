package com.apps.waziup.helper.observer;

import io.reactivex.Observer;

/**
 * This observable is not using onCompleted or onNext
 *
 * @param <T>
 */
public abstract class ErrorObserver<T> implements Observer<T> {

    //@Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        error(e);
    }

    @Override
    public void onNext(T o) {
    }

    public abstract void error(Throwable e);
}
