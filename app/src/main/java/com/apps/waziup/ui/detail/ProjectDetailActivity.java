package com.apps.waziup.ui.detail;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.ui.detail.activity.TabActivityFragment;
import com.apps.waziup.ui.detail.asset.TabAssetsFragment;
import com.apps.waziup.ui.detail.sensor.TabSensorFragment;
import com.apps.waziup.ui.detail.summary.TabSummaryFragment;
import com.apps.waziup.waziup.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectDetailActivity extends BaseActivity implements ProjectDetailContract.View {

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.detail_tabs)
    TabLayout mTabLayout;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabSummaryFragment(), "summary");
        adapter.addFragment(new TabSensorFragment(), "sensors");
        adapter.addFragment(new TabActivityFragment(), "activities");
        adapter.addFragment(new TabAssetsFragment(), "assets");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void attachPresenter(ProjectDetailContract.Presenter presenter) {

    }

    @Override
    public void close() {
        finish();
    }

    //CONTROLS THE SELECTION AND SWIPE FOR THE TABS
    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
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


