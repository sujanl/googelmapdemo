package com.sujan.googlemapdemo;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();

        float lat = bundle.getFloat("latitude");
        float lng = bundle.getFloat("longitude");

        String cityName = null;
//        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
//        List<Address> addressList;
//        try{
//            addressList = geocoder.getFromLocation(lat, lng, 1);
//            if(addressList.size() > 0 )
//                Log.v("city:", addressList.get(0).getLocality());
//            cityName = addressList.get(0).getLocality();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        TextView textView = null;
        textView = findViewById(R.id.value_lat);
        textView.setText(String.valueOf(lat));

        textView = findViewById(R.id.value_lng);
        textView.setText(String.valueOf(lng));

        textView = findViewById(R.id.value_city);
        textView.setText("comming soon");


    }
}
