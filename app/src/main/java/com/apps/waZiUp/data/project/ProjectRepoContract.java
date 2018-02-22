package com.apps.waZiUp.data.project;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 2/22/2018.
 */

/**
 * Post repository contract. A repository will be responsible for managing a number of Posts.
 * It will automatically manage both remote and local sources of posts.
 */

public interface ProjectRepoContract {

    /**
     * Update a project information, such as its status.
     */
    Observable<List<Project>> postProject(Project post);


    /**
     * Retrieve a list of all the  project
     * @return Observable containing a list of all the locally stored  projects
     */
    Observable<List<Project>> getProject();

    /**
     * Update a project information, such as its status.
     */
    Observable<Boolean> updateProject(Project project);

    /**
     * Get project size (local)
     */
    int size();
}
