package com.apps.waziup.ui.project;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.data.BoxStoreProvider;
import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.repo.domain.DomainRepo;
import com.apps.waziup.data.repo.domain.local.DomainLocal;
import com.apps.waziup.data.repo.domain.remote.DomainRemote;
import com.apps.waziup.ui.create.CreateProjectActivity;
import com.apps.waziup.ui.detail.ProjectDetailContract;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProjectActivity extends BaseActivity implements LifecycleRegistryOwner, ProjectContract.View {

//    @Inject
//    ProjectViewModelFactory viewModelFactory;
//    @Inject
//    SyncProjectLifecycleObserver syncProjectLifecycleObserver;

    RecyclerView recyclerView;
    ProgressWheel progressWheel;
    ProjectContract.Presenter presenter;
    @BindView(R.id.projectToolbar)
    Toolbar toolbar;
    @BindView(R.id.project_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private ProjectListAdapter recyclerViewAdapter;
    //    private ProjectViewModel viewModel;
    private LifecycleRegistry registry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ButterKnife.bind(this);

        presenter = new ProjectPresenter(new DomainRepo(
                new DomainLocal(BoxStoreProvider.getStore()),
                new DomainRemote(ProjectActivity.this)
        ));

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressWheel = findViewById(R.id.project_progress_wheel);
        recyclerView = findViewById(R.id.project_recycler_view);
        initRecyclerView();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.loadDomains();
            swipeRefreshLayout.setRefreshing(false);
        });
//        getLifecycle().addObserver(syncProjectLifecycleObserver);
//        viewModel.projects().observe(this, recyclerViewAdapter::updateProjectList);
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
        presenter.attachView(this);//has to be called again or will crash for some scenarios
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

    @Override
    public void showDomains(List<Domain> domains) {
        recyclerViewAdapter.updateProjectList(domains);
    }

    @Override
    public void showDomainDetail(int position) {
        startActivity(new Intent(ProjectActivity.this, ProjectDetailContract.class));
    }

    @Override
    public void showDomainONMap(int position) {
        //this is for routing the method call to open googleMap for showing the project location
        //TODO fix to manual location into automatically form the domain model
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 40.482450, -75.178184);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    @Override
    public void showEditDomainActivity(int position) {
        startActivity(new Intent(ProjectActivity.this, CreateProjectActivity.class));
    }

    @Override
    public void showDeleteDomain(Domain domain) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_delete_project)
                .setPositiveButton(R.string.dialog_ok, (dialog, id) -> {
                    presenter.onDomainDeleteClicked(domain);
                    presenter.loadDomains();
                })
                .setNegativeButton(R.string.dialog_cancel, (dialog, id) -> {
                    // User cancelled the dialog
                    dialog.dismiss();
                });
        builder.create();

    }
}
