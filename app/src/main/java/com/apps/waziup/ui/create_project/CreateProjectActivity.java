package com.apps.waziup.ui.create_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.waziup.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
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

        //zoom in
        fab_zoom_in.setOnClickListener(view -> {
//            locateMap.setVisibility(View.GONE);
            zoomIn();
            Toast.makeText(this, "zoom in", Toast.LENGTH_SHORT).show();
        });

        //zoom out
        fab_zoom_out.setOnClickListener(v->{
            zoomOut();
            Toast.makeText(this, "zoom out", Toast.LENGTH_SHORT).show();
        });

        //for GPS to track the current location
        fab_gps.setOnClickListener(v->{
            zoomOut();
            Toast.makeText(this, "current location", Toast.LENGTH_SHORT).show();
        });

        btn_close.setOnClickListener(view -> finish());
    }

    // Include the OnCreate() method here too, as described above.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.

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
