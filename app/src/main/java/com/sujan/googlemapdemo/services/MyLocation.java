package com.sujan.googlemapdemo.services;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MyLocation {
    private static FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;

    private Context context;
    public MyLocation(Context context){
        this.context=context;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        Log.d("Fused Location Status",fusedLocationProviderClient.toString());
    }


    public Location getLocation() {
        final Location[] currentLocation = new Location[1];

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            Log.d("Error", "Errors in permission");
            return null;
        }
        Log.d("Info", "Permission is granted!");
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener((Activity) context, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            Log.d("Found Location", location.toString());
                            currentLocation[0] = location;
                            Log.d("currentLocation", currentLocation[0].toString());
                        }
                    }
                });
        Log.d("Returning Location", String.valueOf(currentLocation[0]));

        return currentLocation[0];
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getLocation();
                }
                break;
        }
    }
}