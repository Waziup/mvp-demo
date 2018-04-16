package com.apps.waziup.ui.home.projects;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.apps.waziup.domain.project.ProjectUseCase;
import com.apps.waziup.model.Project;
import com.kakai.android.autoviewmodelfactory.annotations.AutoViewModelFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@AutoViewModelFactory
public class ProjectViewModel extends ViewModel {

    private final ProjectUseCase projectUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<List<Project>> projectsLiveData = new MutableLiveData<>();

    public ProjectViewModel(ProjectUseCase projectUseCase) {
        this.projectUseCase = projectUseCase;

        loadProjects();
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

    /**
     * Adds new project
     */
    public void addProject(String projectText) {
        disposables.add(projectUseCase.addProject(projectText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Timber.d("add project success"),
                        t -> Timber.e(t, "add project error")));
    }

    /**
     * Exposes the latest projects so the UI can observe it
     */
    public LiveData<List<Project>> projects() {
        return projectsLiveData;
    }

    void loadProjects() {
        disposables.add(projectUseCase.getProjects()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(projectsLiveData::setValue,
                        t -> Timber.e(t, "get projects error")));
    }
}
