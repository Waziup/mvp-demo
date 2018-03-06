package com.apps.waziup.helper.observer;


import io.reactivex.Observer;

/**
 * This observable is not using onCompleted
 *
 * @param <T>
 */
public abstract class EmptyObserver<T> implements Observer<T> {

    //@Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T o) {
    }
}
