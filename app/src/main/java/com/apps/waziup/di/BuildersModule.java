package com.apps.waziup.di;


import com.apps.waziup.di.scopes.ActivityScope;
import com.apps.waziup.ui.project.ProjectActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = ProjectActivityModule.class)
    abstract ProjectActivity bindProjectActivity();

    // Add bindings for other sub-components here
}
