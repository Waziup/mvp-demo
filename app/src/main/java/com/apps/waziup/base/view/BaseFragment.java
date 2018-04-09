package com.apps.waziup.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.apps.waziup.util.Utils;

import dagger.android.support.DaggerFragment;


/**
 * Base class for all Fragments
 */
public class BaseFragment extends DaggerFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("< -------------------- onCreate(Bundle) -------------------- >");
    }

    @Override
    public void onStart() {
        super.onStart();
        d("< -------------------- onStart() -------------------- >");
    }

    @Override
    public void onResume() {
        super.onResume();
        d("< -------------------- onResume() -------------------- >");
    }

    @Override
    public void onPause() {
        super.onPause();
        d("< -------------------- onPause() -------------------- >");
    }

    @Override
    public void onStop() {
        super.onStop();
        d("< -------------------- onStop() -------------------- >");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        d("< -------------------- onDestroy() -------------------- >");
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
