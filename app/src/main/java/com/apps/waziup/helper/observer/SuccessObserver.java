package com.apps.waziup.helper.observer;

import rx.Observer;

/**
 * This observable is not using onCompleted or onError
 *
 * @param <T>
 */
public abstract class SuccessObserver<T> implements Observer<T> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        System.err.println(e.getMessage());
    }

    @Override
    public void onNext(T o) {
        success(o);
    }

    public abstract void success(T o);
}
