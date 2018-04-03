package com.apps.waziup.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.ui.home.HomeActivity;
import com.apps.waziup.ui.registration.RegistrationActivity;
import com.apps.waziup.waziup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yehuala on 3/30/18
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.link_signup)
    TextView singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        singup.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));

    }

    @OnClick(R.id.btn_login)
    public void onClick(View view){
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void attachPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
    public void openHome() {

    }

    @Override
    public void showValidationError() {

    }

    @Override
    public void openRegistration() {

    }
}
