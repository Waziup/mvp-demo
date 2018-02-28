package com.apps.waZiUp.ui.project.detail;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.apps.waZiUp.base.view.BaseActivity;
import com.apps.waZiUp.waziup.R;

import java.util.ArrayList;
import java.util.List;


public class ProjectDetailActivity extends BaseActivity {

    private Toolbar toolbar;
    private ImageView imageView, tabBg;
    private CollapsingToolbarLayout collapsingToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        tabBg = findViewById(R.id.tabBg);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        //sets the viewpager
        mViewPager = findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        //attaches the viewpager on the tabLayout
        mTabLayout = findViewById(R.id.detail_tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if(position==0){
//                    Glide.with(this).load(R.drawable.onet).into(imageView);
//                    Glide.with(this).load(R.drawable.oneb).into(tabBg);
//                } else {
//                    Glide.with(MainActivity.this).load(R.drawable.twot).into(imageView);
//                    Glide.with(MainActivity.this).load(R.drawable.twob).into(tabBg);
//                }

//                imageView.invalidate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentSensorTab(), "sensors");
        adapter.addFragment(new FragmentActivityTab(), "activities");
        adapter.addFragment(new FragmentActivityTab(), "assets");

        viewPager.setAdapter(adapter);
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


