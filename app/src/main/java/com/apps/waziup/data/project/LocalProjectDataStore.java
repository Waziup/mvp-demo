package com.apps.waziup.data.project;

import com.apps.waziup.domain.LocalProjectRepository;
import com.apps.waziup.model.Project;

import java.util.List;

import io.objectbox.Box;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import kotlin.NotImplementedError;
import timber.log.Timber;

public class LocalProjectDataStore implements LocalProjectRepository {

    //private final ProjectDao projectBox; //Not using DAO here
    private final Box<Project> projectBox;

    public LocalProjectDataStore(Box<Project> projectBox) {
        this.projectBox = projectBox;
    }

    /**
     * Adds a project to a given photo
     */
    public Single<Project> add(long userId, String projectText) {
        Timber.d("creating project for photo id %s, project text %s", userId, projectText);
        Project project = new Project(); //TODO: populate

        return Single.fromCallable(() -> {
            long rowId = projectBox.put(project);
            Timber.d("project stored " + rowId);
            return project; //ProjectUtils.clone(project, rowId);
        });
    }

    /**
     * Updates a project
     */
    public Completable update(Project project) {
        Timber.d("updating project sync status for project id %s", project.getId());

        return Completable.fromAction(() -> projectBox.put(project));  //TODO: check update
    }

    /**
     * Deletes a project
     */
    public Completable delete(Project project) {
        Timber.d("deleting project with id %s", project.getId());

        return Completable.fromAction(() -> projectBox.remove(project));
    }

    /**
     * Returns Flowable stream of projects for a given photo
     */
    public Flowable<List<Project>> getProjects(long userId) {
        Timber.d("getting projects for photo id %s", userId);
        //return Flowable.just(projectBox.getAll());
        throw new NotImplementedError("TODO: Get flowable list of projects from ObjectBox");
    }
}