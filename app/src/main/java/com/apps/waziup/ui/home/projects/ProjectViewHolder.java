package com.apps.waziup.ui.home.projects;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.waziup.R;

import java.util.List;

/**
 * Created by KidusMT on 4/12/2018.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder {

    TextView projectTitle, location;
    ImageView projectImg, projectMarkerLocation, projectEdit, projectDelete;

    public ProjectViewHolder(View itemView) {
        super(itemView);
        projectImg = itemView.findViewById(R.id.project_image);
        projectTitle = itemView.findViewById(R.id.project_title);
        location = itemView.findViewById(R.id.location_value);
        projectMarkerLocation = itemView.findViewById(R.id.project_map_location);
        projectEdit = itemView.findViewById(R.id.project_edit);
        projectDelete = itemView.findViewById(R.id.project_delete);
    }

    public void update(List<Domain> domains){
        Domain domain = domains.get(getAdapterPosition());
        projectTitle.setText(domain.id);
        location.setText(domain.type);
    }
}
