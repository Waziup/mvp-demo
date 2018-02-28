package com.apps.waziup.domain.project;

import com.apps.waziup.model.ModelConstants;
import com.apps.waziup.model.Project;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ProjectUseCase {
    private final LocalProjectRepository localProjectRepository;

    private final RemoteProjectRepository remoteProjectRepository;

    public ProjectUseCase(LocalProjectRepository localProjectRepository, RemoteProjectRepository remoteProjectRepository) {
        this.localProjectRepository = localProjectRepository;
        this.remoteProjectRepository = remoteProjectRepository;
    }

    public Completable addProject(String commentText) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, commentText)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable deleteProject(Project project) {
        return localProjectRepository.delete(project);
    }

    public Completable updateProject(Project project) {
        return localProjectRepository.update(project);
    }

    public Flowable<List<Project>> getProjects() {
        return localProjectRepository.getProjects(ModelConstants.DUMMY_PROJECT_ID);
    }

    public Completable addDevice(String deviceId) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, deviceId)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable toggleDevice(String deviceId) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, deviceId)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable removeDevice(String deviceId) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, deviceId)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable addAsset(String deviceId) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, deviceId)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable removeAsset(String deviceId) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, deviceId)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable addActivity(String deviceId) {
        return localProjectRepository.add(ModelConstants.DUMMY_PROJECT_ID, deviceId)
                .flatMapCompletable(remoteProjectRepository::sync);
    }

    public Completable syncComment(Project project) {
        return remoteProjectRepository.sync(project);
    }


}
