package com.apps.waziup.util;

/**
 * Created by KidusMT on 4/3/2018.
 */

public class ActivityState {

    public static final int STATE_IDLE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_ERROR = 2;

    private static ActivityState instance;

    public static ActivityState getInstance() {
        return instance == null ? instance = new ActivityState() : instance;
    }

    private int state;
    private Throwable error;

    public void setLoading() {
        state = STATE_LOADING;
    }

    public boolean loading() {
        return state == STATE_LOADING;
    }

    public void setCompleted() {
        state = STATE_COMPLETED;
    }

    public boolean completed() {
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
