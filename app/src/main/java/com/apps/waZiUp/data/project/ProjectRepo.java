package com.apps.waZiUp.data.project;

import java.util.List;

import io.reactivex.Observable;


public class ProjectRepo implements ProjectRepoContract {

    @Override
    public Observable<List<Project>> postProject(Project post) {
        return null;
    }

    @Override
    public Observable<List<Project>> getProject() {
        return null;
    }

    @Override
    public Observable<Boolean> updateProject(Project project) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
