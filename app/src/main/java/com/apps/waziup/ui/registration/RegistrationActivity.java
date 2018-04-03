package com.apps.waziup.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.apps.waziup.data.repo.user.UserRepo;
import com.apps.waziup.data.repo.user.local.UserLocal;
import com.apps.waziup.data.repo.user.remote.UserRemote;
import com.apps.waziup.ui.home.HomeActivity;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.View {

    private RegistrationContract.Presenter presenter;
    @BindView(R.id.registration_progress_wheel)
    ProgressWheel progressWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ButterKnife.bind(this);

        presenter = new RegistrationPresenter(new UserRepo(
                new UserLocal(this),
                new UserRemote(this)
        ));

        //hides the keyboard till the user selects to an edit text
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @OnClick(R.id.to_login)
    void openLogin() {
        //TODO not the correct implementation . has to be changed
        showLoginActivity();
    }

    @Override
    public void attachPresenter(RegistrationContract.Presenter presenter) {

    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void showLoading(String message) {
        progressWheel.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressWheel.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressWheel.setVisibility(View.GONE);
    }

    @Override
    public void onUnknownError(String error) {

    }

    @Override
    public void onTimeout() {

    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    protected void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void showHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void showLoginActivity() {
        Utils.e(this.getClass().getSimpleName(), "activity has not been made");
//        startActivity(new Intent(this, LoginActivity.class));
    }
}
