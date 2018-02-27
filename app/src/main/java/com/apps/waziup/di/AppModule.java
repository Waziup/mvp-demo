package com.apps.waziup.di;

import android.content.Context;

import com.apps.waziup.App;
import com.apps.waziup.data.BoxStoreProvider;
import com.apps.waziup.domain.LocalProjectRepository;
import com.apps.waziup.domain.RemoteProjectRepository;
import com.apps.waziup.domain.services.jobs.GcmJobService;
import com.apps.waziup.domain.services.jobs.SchedulerJobService;
import com.apps.waziup.model.Project;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public abstract class AppModule {

    //@Provides
    //@Singleton
    //static Context provideContext(Application application) {
    //    return application;
    //}

    //@Binds
    //abstract Application application(App app);

    @Provides
    static Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    static SchedulerJobService provideSchedulerJobService() {
        return new SchedulerJobService();
    }

    @Singleton
    @Provides
    static GcmJobService provideGcmJobService() {
        return new GcmJobService();
    }

    @Singleton
    @Provides
    static Box<Project> provideProjectBox(Context context) {
        //return CommentDatabase.getInstance(context).commentDao();
        return BoxStoreProvider.getStore().boxFor(Project.class);
    }

    @Singleton
    @Provides
    static LocalProjectRepository provideLocalProjectRepository() {
        return null;
    }

    @Singleton
    @Provides
    static RemoteProjectRepository provideRemoteCommentRepository() {
        return null;
    }
}