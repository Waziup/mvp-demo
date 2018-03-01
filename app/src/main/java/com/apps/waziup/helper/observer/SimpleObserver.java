package com.apps.waziup.helper.observer;

import rx.Observer;

/**
 * This observable is not using onCompleted
 *
 * @param <T>
 */
public abstract class SimpleObserver<T> implements Observer<T> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        error(e);
    }

    @Override
    public void onNext(T o) {
        success(o);
    }

    public abstract void error(Throwable e);

    public abstract void success(T o);
}
