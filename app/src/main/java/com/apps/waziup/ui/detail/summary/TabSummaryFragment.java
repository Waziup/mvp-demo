package com.apps.waziup.ui.detail.summary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.ui.create.CreateProjectContract;
import com.apps.waziup.waziup.R;

import static com.apps.waziup.util.Constants.PROJECT;
import static com.apps.waziup.util.Constants.PROJECT_TYPE;

public class TabSummaryFragment extends BaseFragment implements TabSummaryContract.View {

    String projectTitle = "";
    String projectType = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity().getIntent().getStringExtra(PROJECT).equals("project")) {
            projectTitle = getActivity().getIntent().getStringExtra(PROJECT);
            projectType = getActivity().getIntent().getStringExtra(PROJECT_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_summary, container, false);
        TextView title = v.findViewById(R.id.project_summary_title);
        title.setText((!projectTitle.equals("")) ? projectTitle : "Location");
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void attachPresenter(CreateProjectContract.Presenter presenter) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onUnknownError(String error) {

    }

    @Override
    public void onTimeout() {

    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {

    }
}
