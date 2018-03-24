package com.apps.waziup.di;


import com.apps.waziup.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//@Singleton
//@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
//        AndroidSupportInjectionModule.class,
//        AppModule.class,
//        BuildersModule.class})
//public interface AppComponent {
//    void inject(App app);
//
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        Builder application(App application);
//
//        AppComponent build();
//    }
//}

@Component(modules = {
        AppModule.class,
        BuildersModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}