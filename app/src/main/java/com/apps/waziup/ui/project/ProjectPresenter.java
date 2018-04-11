package com.apps.waziup.ui.project;

/**
 * Created by KidusMT on 4/12/2018.
 */

public class ProjectPresenter implements ProjectContract.Presenter{
    ProjectContract.View view;

    @Override
    public void start() {
        //we stop any loading on the start of the project activity
        view.hideLoading();
    }

    @Override
    public void attachView(ProjectContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public ProjectContract.View getView() {
        return this.view;
    }
}
