package com.sujan.googlemapdemo;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.sujan.googlemapdemo.services.MyLocation;

public class GetMyLocation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("COntext", getApplicationContext().toString());

        Log.d("Location status", "Retrieving!!!!");
        MyLocation myLocation = new MyLocation(this);
        Location location = myLocation.getLocation();
        if(location == null)
            Toast.makeText(this, "Null Location returned!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Location: lat>"+location.getLatitude()+", lng>"+location.getLongitude(),
                    Toast.LENGTH_SHORT).show();

    }


}
