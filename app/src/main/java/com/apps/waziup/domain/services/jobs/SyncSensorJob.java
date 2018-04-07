package com.apps.waziup.domain.services.jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.apps.waziup.domain.services.SyncProjectRxBus;
import com.apps.waziup.domain.services.SyncResponseEventType;
import com.apps.waziup.domain.services.networking.RemoteException;
import com.apps.waziup.domain.services.networking.RemoteProjectService;
import com.apps.waziup.model.Project;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import timber.log.Timber;

public class SyncSensorJob extends Job {

    private static final String TAG = SyncSensorJob.class.getCanonicalName();
    private final Project project;

    public SyncSensorJob(Project project) {
        super(new Params(JobPriority.MID)
                .requireNetwork()
                .groupBy(TAG)
                .persist());
        this.project = project;
    }

    @Override
    public void onAdded() {
        Timber.d("Executing onAdded() for project " + project);
    }

    @Override
    public void onRun() throws Throwable {
        Timber.d("Executing onRun() for project " + project);

        // if any exception is thrown, it will be handled by shouldReRunOnThrowable()
        Project updatedProject = RemoteProjectService.getInstance().addProjectDomain(project);

        //TODO: Clone the updated project!
        // remote call was successful--the ProjectOld will be updated locally to reflect that sync is no longer pending
        //Project updatedProject = project;  //ProjectUtils.clone(project, false);
        SyncProjectRxBus.getInstance().post(SyncResponseEventType.SUCCESS, updatedProject);
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
        Timber.d("canceling job. reason: %d, throwable: %s", cancelReason, throwable);
        // sync to remote failed
        SyncProjectRxBus.getInstance().post(SyncResponseEventType.FAILED, project);
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        if (throwable instanceof RemoteException) {
            RemoteException exception = (RemoteException) throwable;

            int statusCode = exception.getResponse().code();
            if (statusCode >= 400 && statusCode < 500) {
                return RetryConstraint.CANCEL;
            }
        }
        // if we are here, most likely the connection was lost during job execution
        return RetryConstraint.RETRY;
    }
}
