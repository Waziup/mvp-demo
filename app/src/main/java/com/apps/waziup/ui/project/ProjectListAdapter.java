package com.apps.waziup.ui.project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.waziup.R;

import java.util.List;

import timber.log.Timber;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private final List<Domain> projects;
    private ProjectContract.Presenter presenter;

    public ProjectListAdapter(List<Domain> projects, ProjectContract.Presenter presenter) {
        this.projects = projects;
        this.presenter = presenter;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_project_list, parent, false);

        return new ProjectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        final Domain project = projects.get(position);
        holder.projectTitle.setText(project.id);
        holder.location.setText(project.type);
//        Picasso.with(holder.projectImg.getContext()).load(project.imge).into(holder.projectImg);
        holder.projectDelete.setOnClickListener(v -> presenter.onDomainDeleteClicked(project));
        holder.projectEdit.setOnClickListener(v -> presenter.onDomainEditClicked(project));
        holder.projectMarkerLocation.setOnClickListener(v -> presenter.onDomainMarkerClicked(project));
        holder.itemView.setOnClickListener(v -> presenter.onDomainClicked(project));
    }

    @Override
    public int getItemCount() {
        return projects == null ? 0 : projects.size();
    }

    public void updateProjectList(List<Domain> newProjects) {
        Timber.d("Got new projects " + newProjects.size());
        //TODO get back here and fix this mess here
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
