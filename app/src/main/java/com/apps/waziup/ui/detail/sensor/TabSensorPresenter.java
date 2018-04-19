package com.apps.waziup.ui.detail.sensor;

import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.data.repo.sensor.SensorRepoContract;
import com.apps.waziup.ui.detail.ProjectDetailActivity;
import com.apps.waziup.util.ActivityState;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class TabSensorPresenter implements TabSensorContract.Presenter {

    private TabSensorContract.View view;
    private SensorRepoContract repository;
    private ActivityState state;

    public TabSensorPresenter(SensorRepoContract repository) {
        this.repository = repository;
        state = ActivityState.getInstance();
    }

    @Override
    public void start() {
        if (state.loading()) return;
        loadSensors();
    }

    @Override
    public void attachView(TabSensorContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public TabSensorContract.View getView() {
        return this.view;
    }

    @Override
    public void loadSensors() {
        view.showLoading();
        repository
                .getAllSensors(ProjectDetailActivity.domain_id, "", "", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<Sensor>>() {
                    @Override
                    public void onNext(List<Sensor> sensors) {
                        state.setCompleted();
                        if (view == null) return;
                        view.showSensors(sensors);
                        state.reset();
                    }

                    @Override
                    public void onError(Throwable e) {
                        state.setError(e);
                        if (view == null) return;

                        if (e instanceof SocketTimeoutException) {
                            view.onTimeout();
                        } else if (e instanceof IOException) {
                            view.onNetworkError();
                        } else if (e instanceof HttpException) {
                            int code = ((HttpException) e).response().code();
                            if (code >= 400 && code < 404) {
                                view.onUnknownError("Unauthorized! Login again.");
                            } else {
                                ResponseBody responseBody = ((HttpException) e).response().errorBody();
                                try {//should display the correct error message form the http protocol
                                    if (responseBody != null) {
                                        JSONObject jObjError = new JSONObject(responseBody.toString());
                                        view.onUnknownError(jObjError.toString());
                                    }
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        } else {
                            view.onUnknownError(e.getMessage());
                        }
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                });
    }

    @Override
    public void onSensorClick(Sensor sensor) {

    }
}