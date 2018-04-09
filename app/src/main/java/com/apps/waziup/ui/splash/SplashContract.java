package com.apps.waziup.ui.splash;


import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 3/24/2018.
 */

public interface SplashContract {

    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseView<Presenter> {
        void showSplash();
    }
}
