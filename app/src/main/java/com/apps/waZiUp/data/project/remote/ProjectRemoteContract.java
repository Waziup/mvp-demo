package com.apps.waZiUp.data.project.remote;

import com.apps.waZiUp.data.project.Project;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 2/22/2018.
 */

public interface ProjectRemoteContract {

    Observable<List<Project>> getProjects();
}
