package com.apps.waziup.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

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
    @OnClick(R.id.to_login) void openLogin(){
//        startActivity(new Intent(this, LoginActivity.class));
        Toast.makeText(this, "to login", Toast.LENGTH_SHORT).show();
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

    }

    @Override
    public void showLoginActivity() {

//        startActivity(new Intent(this, LoginActivity.class));
    }
}
