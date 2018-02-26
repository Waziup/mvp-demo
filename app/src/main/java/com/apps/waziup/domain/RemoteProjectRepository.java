package com.apps.waziup.domain;

import com.apps.waziup.model.Project;

import io.reactivex.Completable;

public interface RemoteProjectRepository {
    Completable sync(Project project);
}
