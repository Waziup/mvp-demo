package com.apps.waziup.helper.observer;


import io.reactivex.Observer;

/**
 * This observable reacts on onNext or onComplete only once
 */
public abstract class BooleanObserver<T> implements Observer<T> {

    private boolean successSent = false;

    //@Override
    public void onCompleted() {
        if (!successSent) onNext(null);
    }

    @Override
    public void onError(Throwable e) {
        error(e);
    }

    @Override
    public void onNext(T o) {
        if (!successSent) {
            successSent = true;
            success();
        }
    }

    public abstract void error(Throwable e);

    public abstract void success();
}
