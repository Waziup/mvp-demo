package com.apps.waziup.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.ui.login.LoginActivity;
import com.apps.waziup.ui.project.ProjectActivity;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.apps.waziup.util.Constants.APP_NAME;
import static com.apps.waziup.util.Constants.USER_TOKEN;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, HomeContract.View {

    private ActionBarDrawerToggle drawerToggle;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.navView)
    NavigationView navigationView;
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        pref = getSharedPreferences(APP_NAME, MODE_PRIVATE);

        linearLayout = findViewById(R.id.top_layout);
        linearLayout.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, ProjectActivity.class)));
        initialise();
        setUpToolbar();
        setUpDrawer();
    }

    // Initialise ActivityM Data
    private void initialise() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpToolbar() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.humberger);
    }

    @OnClick(R.id.fab)
    void OnFabClicked() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_fragment_create_project, null);
        dialogBuilder.setView(dialogView);
        AlertDialog alertDialog = dialogBuilder.create();

        EditText editText = dialogView.findViewById(R.id.dialog_project_name);
        Button cancel = dialogView.findViewById(R.id.btn_dialog_cancel);
        Button ok = dialogView.findViewById(R.id.btn_dialog_ok);
        cancel.setOnClickListener(v -> alertDialog.dismiss());
        ok.setOnClickListener(v -> Utils.toast(HomeActivity.this, editText.getText().toString().trim()));
        alertDialog.show();

    }

    private void setUpDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
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

        drawerLayout.post(() -> drawerToggle.syncState());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String itemName = (String) item.getTitle();

//        Toast.makeText(this,itemName,Toast.LENGTH_SHORT).show();

        //FOR THE LOGOUT BUTTON
        if (item.getItemId() == R.id.logout_list) {
            editor = pref.edit();
            editor.remove(USER_TOKEN);
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }
        hideDrawer();

        return true;

    }

    //open drawer
    private void showDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    // close drawer
    private void hideDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            hideDrawer();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                // call the adapter filter method
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void attachPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onUnknownError(String error) {

    }

    @Override
    public void onTimeout() {

    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {

    }
}
