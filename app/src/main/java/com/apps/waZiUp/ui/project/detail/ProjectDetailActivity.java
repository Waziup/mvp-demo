package com.apps.waZiUp.ui.project.detail;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.apps.waZiUp.base.view.BaseActivity;
import com.apps.waZiUp.waziup.R;


import java.util.ArrayList;
import java.util.List;

public class ProjectDetailActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        //The toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //sets the viewpager
        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        //attaches the viewpager on the tabLayout
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentDetailTab(), "Detail");
        adapter.addFragment(new FragmentSensorTab(), "Sensors");
        adapter.addFragment(new FragmentActivityTab(), "Activities");

        viewPager.setAdapter(adapter);
    }

    //CONTROLS THE SELECTION AND SWIPE FOR THE TABS
    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
