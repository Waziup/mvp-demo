package com.apps.waziup;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.apps.waziup.di.DaggerAppComponent;
import com.apps.waziup.domain.services.jobs.JobManagerFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class App extends MultiDexApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        DaggerAppComponent
                .builder()
//                .application(this)
                .build()
                .inject(this);

        JobManagerFactory.getJobManager(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    // @Override
    // protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    //     return DaggerApplicationComponent.builder().create(this);
    // }

    //If Cannot extend MultidexApplication
    //@Override
    //protected void attachBaseContext(Context base) {
    //    super.attachBaseContext(base);
    //    MultiDex.install(this);
    //}

}
