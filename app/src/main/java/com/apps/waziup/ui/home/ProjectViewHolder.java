package com.apps.waziup.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.apps.waziup.data.project.ProjectOld;

import java.util.List;

/**
 * Created by yehuala on 2/22/18.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder {

    public ProjectViewHolder(View itemView,final HomeContract.Presenter presenter) {
        super(itemView);

    }

    public void update(List<ProjectOld> projectOldList) {
        ProjectOld projectOld = projectOldList.get(getAdapterPosition());
        // TODO: 2/20/18 get the parameter  for  the projectOld then ...

    }
}
