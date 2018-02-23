package com.apps.waZiUp.ui.create_project;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.waZiUp.base.view.BaseActivity;
import com.apps.waZiUp.waziup.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CreateProjectActivity extends BaseActivity implements OnMapReadyCallback {

    FloatingActionButton fab_zoom_in, fab_zoom_out, fab_gps;

    TextView locateMap;

    Button btn_close;

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_create_project);

        //hides the keyboard till the user selects to an edit text
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        fab_zoom_in = findViewById(R.id.fab_zoom_in_location);
        fab_zoom_out = findViewById(R.id.fab_zoom_out_location);
        fab_gps = findViewById(R.id.fab_current_location);

        locateMap = findViewById(R.id.tv_create_locate_map);

        btn_close = findViewById(R.id.btn_create);

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);

        fab_zoom_in.setOnClickListener(view -> {
//            locateMap.setVisibility(View.GONE);
            zoomIn();
            Toast.makeText(this, "zoom in", Toast.LENGTH_SHORT).show();
        });

        fab_zoom_out.setOnClickListener(v->{
            zoomOut();
            Toast.makeText(this, "zoom out", Toast.LENGTH_SHORT).show();
        });

        fab_gps.setOnClickListener(v->{
            zoomOut();
            Toast.makeText(this, "current location", Toast.LENGTH_SHORT).show();
        });


        btn_close.setOnClickListener(view -> finish());
    }

    /**
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     *
     * If google play service is not installed then the user will be prompted to update or install
     * google play service
     *
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    public void zoomIn(){
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
    }

    public void zoomOut(){
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
    }


}
