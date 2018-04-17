package com.apps.waziup.ui.detail.entity;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;
import com.apps.waziup.ui.create.CreateSensorContract;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface TabEntityContract {

    interface View extends BaseView<CreateSensorContract.Presenter> {

    }

    interface Presenter extends BasePresenter<CreateSensorContract.View> {

    }
}
