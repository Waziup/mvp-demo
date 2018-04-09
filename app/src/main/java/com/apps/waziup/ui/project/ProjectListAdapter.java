package com.apps.waziup.ui.project;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.waziup.R;
import com.apps.waziup.model.Project;

import java.util.List;

import timber.log.Timber;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

    private final List<Project> projects;

    public ProjectListAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView projectText = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_create_project, parent, false); //TODO: Fix
        return new ViewHolder(projectText);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Project project = projects.get(position);
        //TODO: Sync Pending
        if (project.isPublic()) {
            holder.projectText.setTextColor(Color.LTGRAY);
        } else {
            holder.projectText.setTextColor(Color.BLACK);
        }
        holder.projectText.setText(project.getDescription());
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
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView projectText;

        public ViewHolder(final TextView projectText) {
            super(projectText);
            this.projectText = projectText;
        }
    }
}
