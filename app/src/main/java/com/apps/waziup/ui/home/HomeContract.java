package com.apps.waziup.ui.home;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 4/11/2018.
 */

public interface HomeContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
