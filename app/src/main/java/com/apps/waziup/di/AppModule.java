package com.apps.waziup.di;

import android.app.Application;
import android.content.Context;

import com.apps.waziup.App;
import com.apps.waziup.domain.LocalProjectRepository;
import com.apps.waziup.domain.RemoteProjectRepository;
import com.apps.waziup.domain.services.jobs.GcmJobService;
import com.apps.waziup.domain.services.jobs.SchedulerJobService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static Context provideContext(Application application) {
        return application;
    }

    @Binds
    abstract Application application(App app);

    //@Provides
    //Context provideContext(App application) {
    //    return application.getApplicationContext();
    //}

    @Singleton
    @Provides
    SchedulerJobService provideSchedulerJobService() {
        return new SchedulerJobService();
    }

    @Singleton
    @Provides
    GcmJobService provideGcmJobService() {
        return new GcmJobService();
    }

    //@Singleton
    //@Provides
    //CommentDao provideCommentDao(Context context) {
    //    return CommentDatabase.getInstance(context).commentDao();
    //}

    @Singleton
    @Provides
    LocalProjectRepository provideLocalProjectRepository() {
        return null;
    }

    @Singleton
    @Provides
    RemoteProjectRepository provideRemoteCommentRepository() {
        return null;
    }
}