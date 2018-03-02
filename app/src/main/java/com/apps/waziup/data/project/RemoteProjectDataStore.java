package com.apps.waziup.data.project;


import com.apps.waziup.domain.project.RemoteProjectRepository;
import com.apps.waziup.domain.services.jobs.JobManagerFactory;
import com.apps.waziup.domain.services.jobs.SyncProjectJob;
import com.apps.waziup.model.Project;

import io.reactivex.Completable;

public class RemoteProjectDataStore implements RemoteProjectRepository {

    @Override
    public Completable sync(Project project) {
        return Completable.fromAction(() ->
                JobManagerFactory.getJobManager().addJobInBackground(new SyncProjectJob(project)));
    }
}
