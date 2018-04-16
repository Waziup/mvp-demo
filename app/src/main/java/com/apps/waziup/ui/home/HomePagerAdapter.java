package com.apps.waziup.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.apps.waziup.ui.home.Dashboard.DashBordFragment;
import com.apps.waziup.ui.home.projects.ProjectsFragment;

/**
 * Created by yehuala on 4/16/18
 */
public class HomePagerAdapter extends FragmentPagerAdapter{

    private int  mTabCount;
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount=0;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return DashBordFragment.newInstance();
            case 1:
                return ProjectsFragment.newInstance();
        }

        return null;
    }
    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
