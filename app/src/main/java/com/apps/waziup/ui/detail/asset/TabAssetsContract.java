package com.apps.waziup.ui.detail.asset;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;
import com.apps.waziup.ui.create.CreateProjectContract;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface TabAssetsContract {

    interface View extends BaseView<CreateProjectContract.Presenter> {

    }

    interface Presenter extends BasePresenter<CreateProjectContract.View> {

    }
}
