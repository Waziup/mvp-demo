package com.apps.waziup.domain.project;

import com.apps.waziup.model.Project;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Responsible for CRUD operations against local comment repository
 */
public interface LocalProjectRepository {
    Single<Project> add(long photoId, String name);

    Completable update(Project project);

    Completable delete(Project project);

    Flowable<List<Project>> getProjects(long photoId);
}
