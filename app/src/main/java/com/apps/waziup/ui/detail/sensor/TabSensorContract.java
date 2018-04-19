package com.apps.waziup.ui.detail.sensor;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;
import com.apps.waziup.data.model.Sensor;

import java.util.List;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface TabSensorContract {

    interface View extends BaseView<Presenter> {
        void showSensors(List<Sensor> sensorList);
        void showSensorDetailActivity(int sensorPosition);
    }

    interface Presenter extends BasePresenter<View> {
        void loadSensors();
        void onSensorClick(Sensor sensor);
    }
}
