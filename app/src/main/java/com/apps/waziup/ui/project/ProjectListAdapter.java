package com.apps.waziup.ui.project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.model.Project;
import com.apps.waziup.waziup.R;

import java.util.List;

import timber.log.Timber;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private final List<Project> projects;

    public ProjectListAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_create_project, parent, false); //TODO: Fix

        return new ProjectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        final Project project = projects.get(position);
        //TODO: Sync Pending
//        if (project.isPublic()) {
//            holder.projectText.setTextColor(Color.LTGRAY);
//        } else {
//            holder.projectText.setTextColor(Color.BLACK);
//        }
//        holder.projectText.setText(project.getDescription());

    }

    @Override
    public int getItemCount() {
        return projects == null ? 0 : projects.size();
    }

    public void updateProjectList(List<Project> newProjects) {
        Timber.d("Got new projects " + newProjects.size());
        this.projects.clear();
        this.projects.addAll(newProjects);
        notifyDataSetChanged();
    }

    /**
     * View holder for shopping list items of this adapter
     */
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        private TextView projectText;
//
//        public ViewHolder(final TextView projectText) {
//            super(projectText);
//            this.projectText = projectText;
//        }
//    }
}
