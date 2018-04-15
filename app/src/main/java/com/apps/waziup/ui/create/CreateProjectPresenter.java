package com.apps.waziup.ui.create;

import com.apps.waziup.data.repo.sensor.SensorRepoContract;
import com.apps.waziup.util.ActivityState;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class CreateProjectPresenter implements CreateProjectContract.Presenter {

    CreateProjectContract.View view;
    SensorRepoContract repository;
    ActivityState state;
    public CreateProjectPresenter(SensorRepoContract repository){
        this.repository = repository;
        state = ActivityState.getInstance();
    }

    @Override
    public void start() {
        if (state.loading()) return;
        view.hideLoading();
    }

    @Override
    public void attachView(CreateProjectContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public CreateProjectContract.View getView() {
        return this.view;
    }

    @Override
    public void onCreateProjectClicked() {
        view.openProjectList();
    }

    @Override
    public void onZoomInClicked() {
        view.showZoomIn();
    }

    @Override
    public void onZoomOutClicked() {
        view.showZoomOut();
    }

    @Override
    public void onCurrentLocationClicked() {
        view.showCurrentLocation();
    }
}
