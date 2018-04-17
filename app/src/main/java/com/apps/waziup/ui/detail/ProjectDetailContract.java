package com.apps.waziup.ui.detail;

import com.apps.waziup.base.mvp.BasePresenter;
import com.apps.waziup.base.mvp.BaseView;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface ProjectDetailContract {

    interface View extends BaseView<Presenter>{

    }
    interface Presenter extends BasePresenter<View>{

    }
}
