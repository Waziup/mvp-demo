package com.apps.waziup.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.apps.waziup.util.Utils;


/**
 * BaseActivity for supporting the rest of the ActivityM classes, providing common functionality
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("< ------------------------------ onCreate(Bundle) ------------------------------ >");
    }

    @Override
    protected void onStart() {
        super.onStart();
        d("< ------------------------------ onStart() ------------------------------ >");
    }

    @Override
    protected void onResume() {
        super.onResume();
        d("< ------------------------------ onResume() ------------------------------ >");
    }

    @Override
    protected void onPause() {
        super.onPause();
        d("< ------------------------------ onPause() ------------------------------ >");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("< ------------------------------ onStop() ------------------------------ >");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d("< ------------------------------ onDestroy() ------------------------------ >");
    }

    /**
     * Show a debug message to the logcat
     *
     * @param message message to display
     */
    protected void d(String message) {
        Utils.d(this, message);
    }

    /**
     * Show an error message to the logcat
     *
     * @param message message to display
     */
    protected void e(String message) {
        Utils.e(this, message);
    }
}
