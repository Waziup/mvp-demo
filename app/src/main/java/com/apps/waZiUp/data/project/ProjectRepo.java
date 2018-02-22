package com.apps.waZiUp.data.project;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 2/22/2018.
 */

public class ProjectRepo implements ProjectRepoContract {

    @Override
    public Observable<List<Project>> postProject(Project post) {
        return null;
    }

    @Override
    public Observable<List<Project>> getProject(boolean liked) {
        return null;
    }

    @Override
    public Observable<Boolean> updateProject(Project post) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
