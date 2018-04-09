package com.apps.waziup.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.apps.waziup.R;
import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.ui.home.HomeActivity;
import com.apps.waziup.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.apps.waziup.util.Constants.APP_NAME;
import static com.apps.waziup.util.Constants.VERIFIED;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    public SharedPreferences pref;
    @BindView(R.id.splashLogo)
    ImageView splashLogo;
    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        pref = getSharedPreferences(APP_NAME, MODE_PRIVATE);

        presenter = new SplashPresenter();
    }

    private boolean isVerified() {
        return pref.getBoolean(VERIFIED, false);
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
    public void attachPresenter(SplashContract.Presenter presenter) {

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
    public void showSplash() {

        //Its possible to change the animation type anytime
        Animation alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);

        splashLogo.startAnimation(alphaAnim);

        alphaAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (isVerified()) {//has it been verified?
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    intent.putExtra("activity", "splash");
                    startActivity(intent);
                    close();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.putExtra("activity", "splash");
                    startActivity(intent);
                    close();
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

