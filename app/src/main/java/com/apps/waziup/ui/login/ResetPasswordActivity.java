package com.apps.waziup.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apps.waziup.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_reset_password)
    void OnBackToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
