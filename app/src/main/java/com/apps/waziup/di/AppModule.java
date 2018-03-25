package com.apps.waziup.di;

import android.content.Context;

import com.apps.waziup.App;
import com.apps.waziup.domain.project.LocalProjectRepository;
import com.apps.waziup.domain.project.RemoteProjectRepository;
import com.apps.waziup.domain.services.jobs.GcmJobService;
import com.apps.waziup.domain.services.jobs.SchedulerJobService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

    //We avoid hard reference to Box in this interface. The Repositories suffice to hide implementation details
    //@Singleton
    //@Provides
    //static Box<Project> provideProjectBox(Context context) {
    //    //return CommentDatabase.getInstance(context).commentDao();
    //    return BoxStoreProvider.getStore().boxFor(Project.class);
    //}

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