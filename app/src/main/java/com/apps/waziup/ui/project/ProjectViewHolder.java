package com.apps.waziup.ui.project;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.waziup.waziup.R;

/**
 * Created by KidusMT on 4/12/2018.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder {

    TextView projectTitle, location;
    ImageView projectImg;

    public ProjectViewHolder(View itemView) {
        super(itemView);
        projectImg = itemView.findViewById(R.id.project_image);
        projectTitle = itemView.findViewById(R.id.project_title);
        location = itemView.findViewById(R.id.location_value);
    }
}
