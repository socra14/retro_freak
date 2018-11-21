package com.socra.socra.retro_freak.fragments;


import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.socra.socra.retro_freak.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class mapfragments extends Fragment implements OnMapReadyCallback {
    private GoogleMap map;
    private MapView mapView;
    private View rootview;

    public mapfragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =inflater.inflate(R.layout.fragment_mapfragments, container, false);

        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) rootview.findViewById(R.id.map);

        if (mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Blanca = new LatLng(38.179828, -1.375563);
        map.addMarker(new MarkerOptions().position(Blanca).title("Retro Freak"));
         map.moveCamera(CameraUpdateFactory.newLatLng(Blanca));
         map.setMinZoomPreference(18);
       // CameraPosition camera = new CameraPosition.Builder()
         //       .target(Blanca)
           //     .zoom(18)  //limite21
             //   .bearing(30)
               // .tilt(90) //limite90
               // .build();

        //map.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
    }


}
