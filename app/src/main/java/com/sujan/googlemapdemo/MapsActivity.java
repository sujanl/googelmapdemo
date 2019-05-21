package com.sujan.googlemapdemo;

import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private UiSettings uiSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        double[] lats = {27.717174};
//        double[] lngs = {85.346560};
        double lat = 27.717174;
        double lng = 85.346560;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng), 12F));

        List<LatLng> latlngs = new ArrayList<LatLng>();
        for(int i = 1; i<= 5; i++){
            latlngs.add(new LatLng(lat, lng));
            lat = lat + 1;
            lng = lng + 1;
        }
        MarkerOptions options = new MarkerOptions();
        for(LatLng temp:latlngs){
//            mMap.addMarker( new MarkerOptions().position(temp));
            options.position(temp);
            mMap.addMarker(options);

            Log.v("lat&lng :",temp.latitude+" & "+temp.longitude );
        }



        // Add a marker in Chabahil and move the camera
//        LatLng chabahil = new LatLng(27.717174, 85.346560);
//        mMap.addMarker(new MarkerOptions().position(chabahil).title("Marker in Chabahil"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chabahil, 14F));
    }

}
