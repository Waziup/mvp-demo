package com.apps.waziup.base.mvp;

/**
 * Interface representation of a base View in the MVP pattern
 */
public interface BaseView<P extends BasePresenter> {

    /**
     * Attach the Presenter to the view
     */
    void attachPresenter(P presenter);

    /**
     * Dismiss the View from the UI
     */
    void close();

    void showLoading(String message);

    void showLoading();

    void hideLoading();

    void onUnknownError(String error);

    void onTimeout();

    void onNetworkError();

    boolean isNetworkConnected();

    void onConnectionError();
}