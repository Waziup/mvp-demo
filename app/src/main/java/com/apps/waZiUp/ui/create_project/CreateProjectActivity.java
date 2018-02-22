package com.apps.waZiUp.ui.create_project;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

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

    FloatingActionButton fab;

    TextView locateMap;

    Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_create_project);

        fab = findViewById(R.id.fab_pick_location);

        locateMap = findViewById(R.id.tv_create_locate_map);

        btn_close = findViewById(R.id.btn_create);

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);

        fab.setOnClickListener(view -> {
            locateMap.setVisibility(View.GONE);

            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialogmap);
            MapView mMapView = (MapView) dialog.findViewById(R.id.mapView);
            MapsInitializer.initialize(this);

//            GoogleMapOptions options = new GoogleMapOptions().liteMode(true);
            mMapView.onCreate(dialog.onSaveInstanceState());
            mMapView.onResume();


            mMapView.getMapAsync(googleMap -> {
                LatLng posisiabsen = new LatLng(-33.852, 151.211); ////your lat lng
                googleMap.addMarker(new MarkerOptions().position(posisiabsen)
                        .title("Yout title"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(posisiabsen));
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
            });


//            Button dialogButton = (Button) dialog.findViewById(R.id.btn_tutup);
//                // if button is clicked, close the custom dialog
//            dialogButton.setOnClickListener(v -> dialog.dismiss());

            dialog.show();
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
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
