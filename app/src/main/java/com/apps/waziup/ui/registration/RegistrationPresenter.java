package com.apps.waziup.ui.registration;

import com.apps.waziup.data.repo.user.UserRepoContract;
import com.apps.waziup.util.ActivityState;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private RegistrationContract.View view;
    private UserRepoContract repository;
    private ActivityState state;

    public RegistrationPresenter(UserRepoContract repository){
        this.repository = repository;
        this.state = ActivityState.getInstance();
    }

    @Override
    public void start() {
        view.hideLoading();
    }

    @Override
    public void attachView(RegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public RegistrationContract.View getView() {
        return null;
    }

    @Override
    public void onRegistrationClicked() {

    }

    @Override
    public void onLoginClicked() {

    }
}
