package com.apps.waziup.di;


import android.support.v7.app.AppCompatActivity;

import com.apps.waziup.di.scopes.ActivityScope;
import com.apps.waziup.domain.project.LocalProjectRepository;
import com.apps.waziup.domain.project.ProjectUseCase;
import com.apps.waziup.domain.project.RemoteProjectRepository;
import com.apps.waziup.domain.services.SyncProjectLifecycleObserver;
import com.apps.waziup.ui.project.ProjectActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Define ProjectActivity-specific dependencies here.
 */
@Module
public abstract class ProjectActivityModule {

    @Provides
    @ActivityScope
    static SyncProjectLifecycleObserver provideSyncProjectLifecycleObserver(ProjectUseCase projectUseCase) {
        return new SyncProjectLifecycleObserver(projectUseCase);
    }

    //AutoViewFactory will generate the Factory a dn it will be injected
    //@Provides
    //ProjectsViewModelFactory provideProjectsViewModelFactory(ProjectsUseCase projectsUseCase) {
    //    return new ProjectsViewModelFactory(projectsUseCase);
    //}

    @Provides
    @ActivityScope
    static ProjectUseCase provideAddProjectUseCase(LocalProjectRepository localProjectRepository, RemoteProjectRepository remoteProjectRepository) {
        return new ProjectUseCase(localProjectRepository, remoteProjectRepository);
    }

    @Binds
    abstract AppCompatActivity activity(ProjectActivity activity);


    //@Provides
    //SyncProjectUseCase provideSyncProjectUseCase(RemoteProjectRepository remoteProjectRepository) {
    //    return new SyncProjectUseCase(remoteProjectRepository);
    //}
}
