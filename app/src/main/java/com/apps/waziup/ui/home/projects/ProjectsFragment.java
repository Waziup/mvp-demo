package com.apps.waziup.ui.home.projects;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.data.BoxStoreProvider;
import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.repo.domain.DomainRepo;
import com.apps.waziup.data.repo.domain.local.DomainLocal;
import com.apps.waziup.data.repo.domain.remote.DomainRemote;
import com.apps.waziup.ui.create.CreateProjectActivity;
import com.apps.waziup.ui.detail.ProjectDetailActivity;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.apps.waziup.util.Constants.ACTIVITY;
import static com.apps.waziup.util.Constants.PROJECT;
import static com.apps.waziup.util.Constants.PROJECT_TYPE;

/**
 * Created by yehuala on 4/16/18
 */
public class ProjectsFragment extends BaseFragment implements ProjectContract.View {

    RecyclerView recyclerView;
    ProgressWheel progressWheel;
    ProjectPresenter presenter;
    @BindView(R.id.project_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    List<Domain> domains;

    Unbinder unbinder ;

    private ProjectListAdapter recyclerViewAdapter;

    public static ProjectsFragment newInstance() {
        Bundle args = new Bundle();
        ProjectsFragment fragment = new ProjectsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_project, container, false);

        unbinder = ButterKnife.bind(this, v);

        domains = new ArrayList<>();

        presenter = new ProjectPresenter(new DomainRepo(
                new DomainLocal(BoxStoreProvider.getStore()),
                new DomainRemote(getActivity())
        ));

        progressWheel = v.findViewById(R.id.project_progress_wheel);
        recyclerView = v.findViewById(R.id.project_recycler_view);
        initRecyclerView();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.loadDomains();
            swipeRefreshLayout.setRefreshing(false);
        });

        return v;
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new ProjectListAdapter(domains, presenter);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);//has to be called in onStart and onResume or will crash for some scenarios
        presenter.start();
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void attachPresenter(ProjectContract.Presenter presenter) {

    }

    @Override
    public void close() {
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
        Utils.toast(getActivity(), error);
    }

    @Override
    public void onTimeout() {
        Utils.toast(getActivity(), "connection timeout");
    }

    @Override
    public void onNetworkError() {
        Utils.toast(getActivity(), "network error");
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {
        Utils.toast(getActivity(), "connection error");
    }

    @Override
    public void showDomains(List<Domain> domains) {
        recyclerViewAdapter.updateProjectList(domains);
    }

    @Override
    public void showDomainDetail(Domain domain) {
        Intent intent = new Intent(getActivity(), ProjectDetailActivity.class);
        intent.putExtra(ACTIVITY, "project");
        intent.putExtra(PROJECT, domain.id);
        intent.putExtra(PROJECT_TYPE, domain.type);
        startActivity(intent);
    }

    @Override
    public void showDomainONMap(Domain domain) {
        //this is for routing the method call to open googleMap for showing the project location
        //TODO fix to manual location into automatically form the domain model
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 40.482450, -75.178184);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    @Override
    public void showEditDomainActivity(Domain domain) {
        startActivity(new Intent(getActivity(), CreateProjectActivity.class));
    }

    @Override
    public void showDeleteDomain(Domain domain) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_delete_project)
                .setPositiveButton(R.string.dialog_ok, (dialog, id) -> presenter.deleteDomain(domain))
                .setNegativeButton(R.string.dialog_cancel, (dialog, id) -> {
                    // User cancelled the dialog
                    dialog.dismiss();
                });
        builder.create();
        builder.show();
    }
}
