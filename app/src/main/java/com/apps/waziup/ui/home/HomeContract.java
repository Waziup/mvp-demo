package com.apps.waziup.ui.home;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;
import com.apps.waziup.data.project.ProjectOld;

import java.util.List;

public interface HomeContract {

    interface View  extends BaseView<Presenter> {

        void showProgressWheel();
        void hideProgressWheel();

        void showProject(List<ProjectOld> projectOlds);
        void refresh();
        void showLoadingFailedError();

        void openProjct(ProjectOld projectOld);
    }
    interface Presenter extends BasePresenter<View> {
        void loadProject();
        // TODO: 2/22/18 write the method for search
        int getCount();
    }
}
