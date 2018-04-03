package com.apps.waziup.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.data.model.AuthBody;
import com.apps.waziup.data.repo.user.UserRepo;
import com.apps.waziup.data.repo.user.local.UserLocal;
import com.apps.waziup.data.repo.user.remote.UserRemote;
import com.apps.waziup.ui.detail.ProjectDetailActivity;
import com.apps.waziup.ui.home.HomeActivity;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yehuala on 3/30/18
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.link_signup)
    TextView singup;
    @BindView(R.id.login_progress_wheel)
    ProgressWheel progressWheel;
    @BindView(R.id.user_name)
    EditText usernameField;
    @BindView(R.id.password)
    EditText passwordField;

    String usernameValue = "";
    String passwordValue = "";

    AuthBody authBody;

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        //hides the keyboard till the User selects to an edit text
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        presenter = new LoginPresenter(new UserRepo(
                new UserLocal(this),
                new UserRemote(this)
        ));

        singup.setOnClickListener(v -> presenter.registrationClicked());
    }

    public boolean validateUserInput(EditText userName, EditText password) {
        usernameValue = userName.getText().toString().trim();
        passwordValue = password.getText().toString().trim();
        if (usernameValue.equals("")) {
            userName.setError("username is required");
            return false;
        } else if (passwordValue.equals("")) {
            password.setError("password is required");
            return false;
        } else if (!usernameValue.equals("") && !passwordValue.equals("")) {
            return true;
        } else {
            Utils.toast(this, "something is wrong");
            return false;
        }
    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        if (validateUserInput(usernameField, passwordField)) {
            authBody = new AuthBody(usernameValue, passwordValue);
            presenter.loginClicked(authBody);
        }
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
        Utils.toast(this,error);
    }

    @Override
    public void onTimeout() {
        Utils.toast(this,"timeout, retry!");
    }

    @Override
    public void onNetworkError() {
        Utils.toast(this,"network error");
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {
        Utils.toast(this, "connection error");
    }

    @Override
    public void openHome() {
        startActivity(new Intent(this, HomeActivity.class));
        close();
    }

    @Override
    public void showValidationError() {

    }

    @Override
    public void openRegistration() {

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
}
