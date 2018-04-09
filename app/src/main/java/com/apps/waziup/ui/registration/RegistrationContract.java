package com.apps.waziup.ui.registration;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface RegistrationContract {
    interface View extends BaseView<Presenter>{
        void showHomeActivity();
        void showLoginActivity();
    }
    interface Presenter extends BasePresenter<View>{
        void onRegistrationClicked();
        void onLoginClicked();
    }
}
