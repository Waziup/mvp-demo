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
     * Update a post information, such as its status.
     */
    Observable<List<Project>> postProject(Project post);


    /**
     * Retrieve a list of all the posts
     * @return Observable containing a list of all the locally stored posts
     */
    Observable<List<Project>> getProject(boolean liked);

    /**
     * Update a post information, such as its status.
     */
    Observable<Boolean> updateProject(Project post);

    /**
     * Get posts size (local)
     */
    int size();
}
