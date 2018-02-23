package com.apps.waZiUp.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.apps.waZiUp.data.project.Project;

import java.util.List;

/**
 * Created by yehuala on 2/22/18.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder {

    public ProjectViewHolder(View itemView,final HomeContract.Presenter presenter) {
        super(itemView);

    }

    public void update(List<Project> projectList){
        Project project=projectList.get(getAdapterPosition());
        // TODO: 2/20/18 get the parameter  for  the project then ...

    }
}
