package com.apps.waziup.ui.detail.summary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.ui.create.CreateSensorContract;
import com.apps.waziup.ui.detail.ProjectDetailActivity;
import com.apps.waziup.waziup.R;

public class TabSummaryFragment extends BaseFragment implements TabSummaryContract.View {

    String projectTitle = "";
    String project_id = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        project_id = ProjectDetailActivity.domain_id;
        projectTitle = project_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
    public void attachPresenter(CreateSensorContract.Presenter presenter) {

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
