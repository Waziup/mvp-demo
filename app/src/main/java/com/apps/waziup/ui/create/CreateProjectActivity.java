package com.apps.waziup.ui.create;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.waziup.base.view.BaseActivity;
import com.apps.waziup.waziup.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBufferResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class CreateProjectActivity extends BaseActivity implements OnMapReadyCallback, CreateProjectContract.View{

    int DEFAULT_ZOOM = 8;

    boolean mLocationPermissionGranted;

    GoogleMap googleMap;

    LatLng mDefaultLocation;

    GeoDataClient mGeoDataClient;
    PlaceDetectionClient mPlaceDetectionClient;

    public static final String TAG = "CREATE.PROJECT.ACTIVITY";

    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 99;

    private Location mLastKnownLocation;

    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "btnLocation";

    public int M_MAX_ENTRIES = 5;
    public String[] mLikelyPlaceNames;
    public String[] mLikelyPlaceAddresses;
    public String[] mLikelyPlaceAttributions;
    public LatLng[] mLikelyPlaceLatLngs;

    @BindView(R.id.create_location)
    EditText btnLocation;

    Geocoder geocoder;

    private FusedLocationProviderClient mFusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        ButterKnife.bind(this);

        geocoder = new Geocoder(this, Locale.getDefault());

//        if (savedInstanceState != null) {
//            mCurrentLocation = savedInstanceState.getParcelable(KEY_LOCATION);
//            mCameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
//        }
        //hides the keyboard till the user selects to an edit text
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //for getting the current btnLocation place and address of the btnLocation from google map
        mGeoDataClient = Places.getGeoDataClient(this, null);
        mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mDefaultLocation = new LatLng(43.887294, -88.310586);

    }

    @OnClick(R.id.btn_create)
    void createProject() {
        Toast.makeText(this, "Created Project", Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * for zooming out with a floating action button click
     */
    @OnClick(R.id.fab_zoom_out_location)
    void onZoomOut() {
//        Toast.makeText(this, "zoomOut", Toast.LENGTH_SHORT).show();
        googleMap.animateCamera(CameraUpdateFactory.zoomOut());
    }

    /**
     * for zooming in with a floating action button click
     */
    @OnClick(R.id.fab_zoom_in_location)
    void onZoomIn() {
//        Toast.makeText(this, "zoomOut", Toast.LENGTH_SHORT).show();
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
    }

    /**
     * method to get a list of likely places at the device's current btnLocation:
     */
    @OnClick(R.id.fab_current_location)
    void currentLocation() {
//        Toast.makeText(this, "Current Location", Toast.LENGTH_SHORT).show();
        getDeviceLocation();
    }

    /**
     * asks for the user to accept the request permission for accessing using the btnLocation of
     * the user/device for manipulation
     */
    private void getLocationPermission() {
    /*
     * Request btnLocation permission, so that we can get the btnLocation of the
     * device. The result of the permission request is handled by a callback,
     * onRequestPermissionsResult.
     */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
        updateLocationUI();
    }

    /**
     * this is the method that is being called for preparing the map and all the components that
     * are defined on the map. No map methods or action are called before this because this is
     * where the map gets initialized first
     *
     * @param map
     */
    @Override
    public void onMapReady(GoogleMap map) {

        googleMap = map;

        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

        // Get the current btnLocation of the device and set the position of the map.
        getDeviceLocation();

        // Do other setup activities here too, as described elsewhere in this tutorial.
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            // Return null here, so that getInfoContents() is called next.
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Inflate the layouts for the info window, title and snippet.
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_contents, null);

                TextView title = infoWindow.findViewById(R.id.title);
                title.setText(marker.getTitle());

                TextView snippet = infoWindow.findViewById(R.id.snippet);
                snippet.setText(marker.getSnippet());

                return infoWindow;
            }
        });

        googleMap.setOnMapClickListener(latLng -> showCurrentPlace());

    }

    private void showCurrentPlace() {
        if (googleMap == null) {
            return;
        }

        if (mLocationPermissionGranted) {
            // Get the likely places - that is, the businesses and other points of interest that
            // are the best match for the device's current btnLocation.
            @SuppressWarnings("MissingPermission")
            final Task<PlaceLikelihoodBufferResponse> placeResult =
                    mPlaceDetectionClient.getCurrentPlace(null);
            placeResult.addOnCompleteListener
                    (task -> {
                        if (task.isSuccessful() && task.getResult() != null) {
                            PlaceLikelihoodBufferResponse likelyPlaces = task.getResult();

                            // Set the count, handling cases where less than 5 entries are returned.
                            int count;
                            if (likelyPlaces.getCount() < M_MAX_ENTRIES) {
                                count = likelyPlaces.getCount();
                            } else {
                                count = M_MAX_ENTRIES;
                            }

                            int i = 0;
                            mLikelyPlaceNames = new String[count];
                            mLikelyPlaceAddresses = new String[count];
                            mLikelyPlaceAttributions = new String[count];
                            mLikelyPlaceLatLngs = new LatLng[count];

                            for (PlaceLikelihood placeLikelihood : likelyPlaces) {
                                // Build a list of likely places to show the user.
                                mLikelyPlaceNames[i] = (String) placeLikelihood.getPlace().getName();
                                mLikelyPlaceAddresses[i] = (String) placeLikelihood.getPlace()
                                        .getAddress();
                                mLikelyPlaceAttributions[i] = (String) placeLikelihood.getPlace()
                                        .getAttributions();
                                mLikelyPlaceLatLngs[i] = placeLikelihood.getPlace().getLatLng();

                                i++;
                                if (i > (count - 1)) {
                                    break;
                                }
                            }

                            // Release the place likelihood buffer, to avoid memory leaks.
                            likelyPlaces.release();

                            // Show a dialog offering the user the list of likely places, and add a
                            // marker at the selected place.
                            openPlacesDialog();

                        } else {
                            Timber.e("Exception: " + task.getException());
                        }
                    });
        } else {
            // The user has not granted permission.
            Timber.i("The user did not grant btnLocation permission.");

            // Add a default marker, because the user hasn't selected a place.
            googleMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.default_info_title))
                    .position(mDefaultLocation)
                    .snippet(getString(R.string.default_info_snippet)));

            // Prompt the user for permission.
            getLocationPermission();
        }
    }

    /**
     * update the btnLocation ui in a googleMap according to the current btnLocation and configuration
     */
    private void updateLocationUI() {
        if (googleMap == null) {
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                googleMap.setMyLocationEnabled(false);
                googleMap.getUiSettings().setMyLocationButtonEnabled(false);
                mLastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e) {
            Timber.e(e.getMessage());
        }
    }

    /**
     * for tracking the btnLocation of the mobile for showing the current btnLocation of the user on map
     */
    private void getDeviceLocation() {
    /*
     * Get the best and most recent btnLocation of the device, which may be null in rare
     * cases when a btnLocation is not available.
     */
        try {
            if (mLocationPermissionGranted) {
                Task locationResult = mFusedLocationProviderClient.getLastLocation();
                locationResult.addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Set the map's camera position to the current btnLocation of the device.
                        mLastKnownLocation = (Location) task.getResult();
//                        addMarker(googleMap, mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude(),
//                                mLastKnownLocation.getProvider().);
//                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
//                                new LatLng(mLastKnownLocation.getLatitude(),
//                                        mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                        //CameraUpdateFactory.zoomIn()
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(),
                                mLastKnownLocation.getLongitude()),10), 2000, null);

                    } else {
                        Timber.d("Current btnLocation is null. Using defaults.");
                        Timber.e("Exception:" + task.getException());
//                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mDefaultLocation,
//                                DEFAULT_ZOOM));
                        //animate the camera slowly
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(),
                                mLastKnownLocation.getLongitude()),10), 2000, null);
//                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
                        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
                    }
                });
            }
        } catch (SecurityException e) {
            Timber.e(e.getMessage());
        }
    }

    /**
     * for adding the marker on a specific lat and long with a title and snippet description
     *
     * @param map
     * @param lat
     * @param lon
     * @param title
     * @param snippet
     */
    private void addMarker(GoogleMap map, double lat, double lon, int title, int snippet) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                .title(getString(title))
                .snippet(getString(snippet)));
    }

    /**
     * method to display a form allowing the user to select a place from a list of likely places.
     */
    private void openPlacesDialog() {
        // Ask the user to choose the place where they are now.
        DialogInterface.OnClickListener listener = (dialog, which) -> {
            // The "which" argument contains the position of the selected item.
            LatLng markerLatLng = mLikelyPlaceLatLngs[which];
            String markerSnippet = mLikelyPlaceAddresses[which];
            if (mLikelyPlaceAttributions[which] != null) {
                markerSnippet = markerSnippet + "\n" + mLikelyPlaceAttributions[which];
            }

            // Add a marker for the selected place, with an info window
            // showing information about that place.
            googleMap.addMarker(new MarkerOptions()
                    .title(mLikelyPlaceNames[which])
                    .position(markerLatLng)
                    .snippet(markerSnippet));

            try {
                List<Address> addresses = geocoder.getFromLocation(markerLatLng.latitude, markerLatLng.longitude, 1);
                btnLocation.setText(addresses.get(0).getAddressLine(0).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Position the map's camera at the btnLocation of the marker.
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(markerLatLng,DEFAULT_ZOOM), 1000, null);
//            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(markerLatLng, DEFAULT_ZOOM));
        };

        // Display the dialog.
//        AlertDialog dialog =
        new AlertDialog.Builder(this)
                .setTitle(R.string.pick_place)
                .setItems(mLikelyPlaceNames, listener)
                .show();
    }

    /**
     * for saving the camera and btnLocation setting for the current view before the activity
     * is destroyed or get back to a background for next time retrieving and displaying from
     * where the user has left of the map
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (googleMap != null) {
            outState.putParcelable(KEY_CAMERA_POSITION, googleMap.getCameraPosition());
            outState.putParcelable(KEY_LOCATION, mLastKnownLocation);
            super.onSaveInstanceState(outState);
        }
    }

    @Override
    public void attachPresenter(CreateProjectContract.Presenter presenter) {

    }

    @Override
    public void close() {
        finish();
    }
}
