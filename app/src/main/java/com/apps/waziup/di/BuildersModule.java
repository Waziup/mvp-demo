package com.apps.waziup.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = ProjectActivityModule.class)
    abstract ProjectActivity bindCommentsActivity();

    // Add bindings for other sub-components here
}
