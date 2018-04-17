package com.apps.waziup.ui.create;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface CreateSensorContract {
    interface View extends BaseView<Presenter> {
        void openProjectList();
        void showCurrentLocation();
        void showZoomIn();
        void showZoomOut();
    }

    interface Presenter extends BasePresenter<View> {
        void onCreateProjectClicked();
        void onZoomInClicked();
        void onZoomOutClicked();
        void onCurrentLocationClicked();
    }
}
