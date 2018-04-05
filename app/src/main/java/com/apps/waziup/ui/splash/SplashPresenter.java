package com.apps.waziup.ui.splash;

/**
 * Created by KidusMT on 3/24/2018.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;

    @Override
    public void start() {
        view.showSplash();
    }

    @Override
    public void attachView(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public SplashContract.View getView() {
        return view;
    }

}
