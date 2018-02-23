package com.apps.waZiUp.ui.home;

import com.apps.waZiUp.base.mvp.BasePresenter;
import com.apps.waZiUp.base.mvp.BaseView;
import com.apps.waZiUp.data.project.Project;

import java.util.List;

public interface HomeContract {

    interface View  extends BaseView<Presenter> {

        void showProgressWheel();
        void hideProgressWheel();
        void showProject(List<Project> projects);
        void refresh();
        void showLoadingFailedError();
        void openProjct(Project project);
    }
    interface Presenter extends BasePresenter<View> {
        void loadProject();
        // TODO: 2/22/18 write the method for search
        int getCount();
    }
}
