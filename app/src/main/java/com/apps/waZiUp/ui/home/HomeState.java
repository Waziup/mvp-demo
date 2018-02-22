package com.apps.waZiUp.ui.home;

import static com.apps.waZiUp.util.Constants.STATE_COMPLETED;
import static com.apps.waZiUp.util.Constants.STATE_ERROR;
import static com.apps.waZiUp.util.Constants.STATE_IDLE;
import static com.apps.waZiUp.util.Constants.STATE_LOADING;


public class HomeState {

    private static HomeState instance;

    public static HomeState getInstance() {
        return instance == null ? instance = new HomeState() : instance;
    }
    private int state;
    private Throwable error;

    public void setLoading() {
        state = STATE_LOADING;
    }

    public boolean isLoading() {
        return state == STATE_LOADING;
    }

    public void setCompleted() {
        state = STATE_COMPLETED;
    }

    public boolean isCompleted() {
        return state == STATE_COMPLETED;
    }

    public boolean error() {
        return state == STATE_ERROR && error != null;
    }

    public void setError(Throwable error) {
        state = STATE_ERROR;
        this.error = error;
    }


    public Throwable getError() {
        return error;
    }

    public void reset() {
        state = STATE_IDLE;
        error = null;
    }
}
