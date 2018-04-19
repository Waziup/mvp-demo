package com.apps.waziup.ui.detail.sensor;

import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.data.repo.sensor.SensorRepoContract;
import com.apps.waziup.util.ActivityState;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class TabSensorPresenter implements TabSensorContract.Presenter {

    private TabSensorContract.View view;
    private SensorRepoContract repository;
    private ActivityState state;

    public TabSensorPresenter(SensorRepoContract repository) {
        this.repository = repository;
        state = ActivityState.getInstance();
    }

    @Override
    public void start() {
        if (state.loading()) return;
//        loadDomains();
    }

    @Override
    public void attachView(TabSensorContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public TabSensorContract.View getView() {
        return this.view;
    }

    @Override
    public void loadSensors() {
//        repository.getAllSensors()
    }

    @Override
    public void onSensorClick(Sensor sensor) {
    }
}