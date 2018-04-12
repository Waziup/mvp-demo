package com.apps.waziup.ui.create;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class CreateProjectPresenter implements CreateProjectContract.Presenter {

    CreateProjectContract.View view;

    public CreateProjectPresenter(){

    }

    @Override
    public void start() {

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
