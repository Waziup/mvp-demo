package com.apps.waziup.ui.login;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void openHome();
        void showValidationError();
        void openRegistration();
    }

    interface Presenter extends BasePresenter<View> {
        void loginClicked();
        void registrationClicked();
    }
}
