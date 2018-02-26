package com.apps.waziup.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.apps.waziup.data.project.ProjectOld;
import com.apps.waziup.waziup.R;

import java.util.List;



public class ProjectListAdapter extends RecyclerView.Adapter<ProjectViewHolder>  implements Filterable {

    private List<ProjectOld> projectOlds;
    private HomeContract.Presenter presenter;


    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_layout, parent, false);
        return new ProjectViewHolder(itemView, presenter);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.update(projectOlds);
    }

    @Override
    public int getItemCount() {
        return projectOlds.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
