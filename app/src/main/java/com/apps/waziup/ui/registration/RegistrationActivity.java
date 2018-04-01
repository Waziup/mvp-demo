package com.apps.waziup.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.apps.waziup.ui.home.HomeActivity;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ButterKnife.bind(this);

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
    public void showHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void showLoginActivity() {
        Utils.e(this.getClass().getSimpleName(), "activity has not been made");
//        startActivity(new Intent(this, LoginActivity.class));
    }
}
