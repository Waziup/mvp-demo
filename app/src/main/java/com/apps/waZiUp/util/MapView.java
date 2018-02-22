package com.apps.waZiUp.util;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by KidusMT on 2/22/2018.
 */

public class MapView extends FrameLayout {

    private Subject<GoogleMap> mapSubject;

    public MapView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public MapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MapView(@NonNull Context context, @Nullable AttributeSet attrs,
                   @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();

        if (!isInEditMode()) {
            FragmentTransaction fragmentTransaction =
                    ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(getId(), mapFragment);
            fragmentTransaction.commit();

            mapSubject = BehaviorSubject.create();
//            Observable.create(
//                    (ObservableOnSubscribe<GoogleMap>) e -> mapFragment.getMapAsync(e::onNext))
//                    .subscribe(mapSubject);
        }
    }

   /* public void addMarker(Location location) {
        mapSubject.subscribe(googleMap -> {
            LatLng position = new LatLng(location.lat(), location.lng());
            googleMap.addMarker(new MarkerOptions()
                    .position(position));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(position));
        });
    }*/
}
