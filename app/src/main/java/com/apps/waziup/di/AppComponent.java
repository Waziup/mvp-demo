package com.apps.waziup.di;

import com.example.offline.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class})
public interface AppComponent {
    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }
}
