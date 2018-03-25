package com.apps.waziup.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps.waziup.waziup.R;

import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.login_forgot_password)
    void onForgotPassword(){
        startActivity(new Intent(this, ResetPasswordActivity.class));
        finish();
    }
}
