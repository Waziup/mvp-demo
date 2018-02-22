package com.apps.waZiUp.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.apps.waZiUp.base.view.BaseActivity;
import com.apps.waZiUp.waziup.R;


public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialise();
        setUpToolbar();
        setUpDrawer();

    }

    // Initialise Activity Data
    private void initialise() {
        toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        drawerLayout=  findViewById(R.id.drawer_layout);
        navigationView=  findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpToolbar() {
//        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }


    private void  setUpDrawer()
    {
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.drawer_open,R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);

        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String itemName= (String) item.getTitle();

//        Toast.makeText(this,itemName,Toast.LENGTH_SHORT).show();
        hideDrawer();

        return true;

    }
    //open drawer
    private void showDrawer()
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    // close drawer
    private void hideDrawer()
    {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            hideDrawer();
        }
        super.onBackPressed();
    }
}
