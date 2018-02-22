package com.apps.waZiUp.ui.detail_project;


import com.apps.waZiUp.base.mvp.BasePresenter;
import com.apps.waZiUp.base.mvp.BaseView;

/**
 * Created by KidusMT on 2/22/2018.
 */

public interface DetailContract {

    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseView<Presenter> {

        /**
         * for opening the create project Activity
         */
        void openCreateProject();

//        void

    }
}
