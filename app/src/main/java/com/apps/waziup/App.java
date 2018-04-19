package com.apps.waziup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.apps.waziup.data.BoxStoreProvider;
import com.apps.waziup.util.NetworkStateChangeReceiver;
import com.apps.waziup.waziup.BuildConfig;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class App extends MultiDexApplication implements HasActivityInjector {

    private static final String WIFI_STATE_CHANGE_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @SuppressLint("StaticFieldLeak")
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        BoxStoreProvider.create(this);
        registerForNetworkChangeEvents(this);
        context = getApplicationContext();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

//        DaggerAppComponent
//                .builder()
////                .application(this)
//                .build()
//                .inject(this);

//        JobManagerFactory.getJobManager(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    // @Override
    // protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    //     return DaggerApplicationComponent.builder().create(this);
    // }

//    If Cannot extend MultidexApplication
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext(){
        return context;
    }

    public static void registerForNetworkChangeEvents(final Context context) {
        NetworkStateChangeReceiver networkStateChangeReceiver = new NetworkStateChangeReceiver();
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(WIFI_STATE_CHANGE_ACTION));
    }

}
