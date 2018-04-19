package com.apps.waziup.ui.sensor;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 4/19/2018.
 */

public interface SensorContract {

    interface View extends BaseView<Presenter>{

    }
    interface Presenter extends BasePresenter<View> {

    }
}
