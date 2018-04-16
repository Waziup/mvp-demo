package com.apps.waziup.ui.home.projects;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;
import com.apps.waziup.data.model.Domain;

import java.util.List;

/**
 * Created by KidusMT on 4/16/2018.
 */

public interface ProjectContract {
    interface View extends BaseView<com.apps.waziup.ui.project.ProjectContract.Presenter> {
        void showDomains(List<Domain> domains);
        void showDomainDetail(Domain domain);
        void showDomainONMap(Domain domain);
        void showEditDomainActivity(Domain domain);
        void showDeleteDomain(Domain domain);
    }

    interface Presenter extends BasePresenter<com.apps.waziup.ui.project.ProjectContract.View> {
        void loadDomains();
        void onDomainMarkerClicked(Domain domain);
        void onDomainEditClicked(Domain domain);
        void onDomainDeleteClicked(Domain domain);
        void onDomainClicked(Domain domain);
    }
}
