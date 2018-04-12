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
        void showDomainDetail(int position);
        void showDomainONMap(int position);
        void showEditDomainActivity(int position);
        void showDeleteDomain(Domain domain);
    }

    interface Presenter extends BasePresenter<View>{
        void loadDomains();
        void onDomainMarkerClicked(int position);
        void onDomainEditClicked(int position);
        void onDomainDeleteClicked(Domain domain);
        void onDomainClicked(int position);
    }
}
