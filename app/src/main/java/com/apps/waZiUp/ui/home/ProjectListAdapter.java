package com.apps.waZiUp.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.apps.waZiUp.data.project.Project;
import com.apps.waZiUp.waziup.R;

import java.util.List;



public class ProjectListAdapter extends RecyclerView.Adapter<ProjectViewHolder>  implements Filterable {

    private List<Project> projects;
    private HomeContract.Presenter presenter;


    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_layout, parent, false);
        return new ProjectViewHolder(itemView, presenter);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.update(projects);
    }

    @Override
    public int getItemCount() {
        return  projects.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
