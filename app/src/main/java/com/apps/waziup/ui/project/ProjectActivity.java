package com.apps.waziup.ui.project;

import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.apps.waziup.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;


public class ProjectActivity extends DaggerAppCompatActivity {

//    @Inject
//    ProjectViewModelFactory viewModelFactory;

//    @Inject
//    SyncProjectLifecycleObserver syncProjectLifecycleObserver;

    //TODO: Change to proper layout items using ButterKnife
    //@BindView(R.id.ad_label)
    EditText addProjectEditText;

//    @BindView(R.id.project_title)
    RecyclerView recyclerView;

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

        initRecyclerView();

//        getLifecycle().addObserver(syncProjectLifecycleObserver);

//        viewModel.projects().observe(this, recyclerViewAdapter::updateProjectList);
    }

    @OnClick(R.id.all)
    void onAddProjectButtonClicked() {

        hideKeyboard();

        // TODO add project validation
//        viewModel.addProject(addProjectEditText.getText().toString());

        clearEditText();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
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
}
