package com.apps.waZiUp.ui.home;


import com.apps.waZiUp.data.project.Project;
import com.apps.waZiUp.data.project.remote.ProjectRemoteContract;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

    private ProjectRemoteContract repository;
    private HomeContract.View view;
    private HomeState state;

    public HomePresenter(ProjectRemoteContract repository){
        this.repository=repository;
        this.state=HomeState.getInstance();
    }

    @Override
    public void start() {
        if(state.isLoading()) return;
        loadProject();
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public HomeContract.View getView() {
        return this.view;
    }

    @Override
    public void loadProject() {
//        view.showProgressWheel();
//        repository.getProjects()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())  // running on the main ui
//                .subscribe(new DisposableObserver<List<Project>>() {
//                    @Override
//                    public void onNext(List<Project> projects) {
//                        state.setCompleted();
//                        if (view == null) return;
//                        view.hideProgressWheel();
//                        view.showProject(projects);
//                        state.reset();
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        state.setError(throwable);
//
//                        if (view == null) return;
//                        view.showLoadingFailedError();
//
//                        throwable.printStackTrace();
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public int getCount() {
        return 0;    // TODO: 2/20/18  call the repository size
    }
}
