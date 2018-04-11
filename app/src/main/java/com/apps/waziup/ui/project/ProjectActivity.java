package com.apps.waziup.ui.project;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;


public class ProjectActivity extends DaggerAppCompatActivity implements LifecycleRegistryOwner, ProjectContract.View {

//    @Inject
//    ProjectViewModelFactory viewModelFactory;

//    @Inject
//    SyncProjectLifecycleObserver syncProjectLifecycleObserver;

    //@BindView(R.id.ad_label)
    EditText addProjectEditText;

    //    @BindView(R.id.project_title)
    RecyclerView recyclerView;
    ProgressWheel progressWheel;
    ProjectContract.Presenter presenter;
    @BindView(R.id.projectToolbar)
    Toolbar toolbar;

    private ProjectListAdapter recyclerViewAdapter;

//    private ProjectViewModel viewModel;

    private LifecycleRegistry registry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter = new ProjectPresenter();

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressWheel = findViewById(R.id.project_progress_wheel);

        initRecyclerView();

//        getLifecycle().addObserver(syncProjectLifecycleObserver);

//        viewModel.projects().observe(this, recyclerViewAdapter::updateProjectList);
    }

    @OnClick(R.id.all)
    void onAddProjectButtonClicked() {

        Utils.hideKeyboard(ProjectActivity.this);

//        viewModel.addProject(addProjectEditText.getText().toString());

        clearEditText();
    }

    private void clearEditText() {
        addProjectEditText.getText().clear();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new ProjectListAdapter(new ArrayList<>());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    protected void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void attachPresenter(ProjectContract.Presenter presenter) {

    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void showLoading(String message) {
        progressWheel.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressWheel.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressWheel.setVisibility(View.GONE);
    }

    @Override
    public void onUnknownError(String error) {
        Utils.toast(this, error);
    }

    @Override
    public void onTimeout() {
        Utils.toast(this, "connection timeout");
    }

    @Override
    public void onNetworkError() {
        Utils.toast(this, "network error");
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {
        Utils.toast(this, "connection error");
    }
}
