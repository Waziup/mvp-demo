package com.apps.waziup.ui.project;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.repo.domain.DomainRepoContract;
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
 * Created by KidusMT on 4/12/2018.
 */

public class ProjectPresenter implements ProjectContract.Presenter {

    private ProjectContract.View view;
    private DomainRepoContract repository;
    private ActivityState state;

    public ProjectPresenter(DomainRepoContract repository) {
        this.repository = repository;
        state = ActivityState.getInstance();
    }

    @Override
    public void start() {
        if (state.loading()) return;
        loadDomains();
    }

    @Override
    public void attachView(ProjectContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public ProjectContract.View getView() {
        return this.view;
    }

    @Override
    public void loadDomains() {
        view.showLoading();
        repository.getDomains()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<Domain>>() {
                    @Override
                    public void onNext(List<Domain> domains) {
                        state.setCompleted();

                        if (view == null) return;
                        view.hideLoading();
                        view.showDomains(domains);

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
                        state.setCompleted();
                    }
                });
    }

    @Override
    public void onDomainMarkerClicked(Domain domain) {
        view.showDomainONMap(domain);
    }

    @Override
    public void onDomainEditClicked(Domain domain) {
        view.showEditDomainActivity(domain);
    }

    @Override
    public void onDomainDeleteClicked(Domain domain) {
        //nothing happens until the user clicks ok to the dialog
        if (view.showDeleteDomain()) {
            view.showLoading();
            repository.deleteDomain(domain)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<String>() {
                        @Override
                        public void onNext(String s) {
                            state.setCompleted();
                            if (view == null) return;
                            loadDomains();
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
    }

    @Override
    public void onDomainClicked(Domain domain) {
        view.showDomainDetail(domain);
    }
}
