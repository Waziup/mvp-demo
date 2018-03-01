package com.apps.waziup.domain.services;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.apps.waziup.domain.ProjectUseCase;
import com.apps.waziup.model.Project;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Updates local database after remote comment sync requests
 */
public class SyncProjectLifecycleObserver implements LifecycleObserver {
    private final ProjectUseCase projectUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();

    public SyncProjectLifecycleObserver(ProjectUseCase projectUseCase) {
        this.projectUseCase = projectUseCase;

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Timber.d("onResume lifecycle event.");
        disposables.add(SyncProjectRxBus.getInstance().toObservable()
                .subscribe(this::handleSyncResponse, t -> Timber.e(t, "error handling sync response")));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Timber.d("onPause lifecycle event.");
        disposables.clear();
    }

    private void handleSyncResponse(SyncProjectResponse response) {
        if (response.eventType == SyncResponseEventType.SUCCESS) {
            onSyncProjectSuccess(response.project);
        } else {
            onSyncCommentFailed(response.project);
        }
    }

    private void onSyncProjectSuccess(Project project) {
        Timber.d("received sync project success event for project %s", project);
        disposables.add(projectUseCase.updateProject(project)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Timber.d("update project success"),
                        t -> Timber.e(t, "update project error")));
    }

    private void onSyncCommentFailed(Project project) {
        Timber.d("received sync project failed event for project %s", project);
        disposables.add(projectUseCase.deleteProject(project)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Timber.d("delete project success"),
                        t -> Timber.e(t, "delete project error")));
    }
}
