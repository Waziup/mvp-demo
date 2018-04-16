package com.apps.waziup.ui.home.projects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.waziup.R;

/**
 * Created by yehuala on 4/16/18
 */
public class ProjectsFragment extends BaseFragment {

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
        return  inflater.inflate(R.layout.fragment_home, container, false);
    }
}
