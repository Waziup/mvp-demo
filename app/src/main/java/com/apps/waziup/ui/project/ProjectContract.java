package com.apps.waziup.ui.project;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;
import com.apps.waziup.data.model.Domain;

import java.util.List;

/**
 * Created by KidusMT on 4/12/2018.
 */

public interface ProjectContract {

    interface View extends BaseView<Presenter>{
        void showDomains(List<Domain> domains);
        void showDomainDetail(Domain domain);
        void showDomainONMap(Domain domain);
        void showEditDomainActivity(Domain domain);
        boolean showDeleteDomain();
    }

    interface Presenter extends BasePresenter<View>{
        void loadDomains();
        void onDomainMarkerClicked(Domain domain);
        void onDomainEditClicked(Domain domain);
        void onDomainDeleteClicked(Domain domain);
        void onDomainClicked(Domain domain);
    }
}
