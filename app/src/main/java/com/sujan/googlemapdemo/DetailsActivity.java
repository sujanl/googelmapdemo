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

        double lat = bundle.getDouble("latitude");
        double lng = bundle.getDouble("longitude");
        Log.d("Location ", "lat>"+lat+", lng>"+lng);

        String cityName = null;
        try {
            cityName = getAddress(lat, lng);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView textView = null;
        textView = findViewById(R.id.value_lat);
        textView.setText(String.valueOf(lat));

        textView = findViewById(R.id.value_lng);
        textView.setText(String.valueOf(lng));

        textView = findViewById(R.id.value_city);
        textView.setText(cityName);


    }

    private String getAddress(double latitude, double longitude) throws IOException {
        Log.d("Location ", "lat>"+latitude+", lng>"+longitude);
        String keyLocation = null;
        String address = null, city = null, state = null, country = null, postalCode = null, knownName = null;
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {

                address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                city = addresses.get(0).getLocality();
                state = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                postalCode = addresses.get(0).getPostalCode();
                knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                Log.d("Address", "getAddress:  address>>" + address);
                Log.d("City", "getAddress:  city>>" + city);
                Log.d("State", "getAddress:  state>>" + state);
                Log.d("Code", "getAddress:  postalCode>>" + postalCode);
                Log.d("Known Name", "getAddress:  knownName>>" + knownName);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        keyLocation = "Address: "+address+", City: "+city+", state: "+state
                +", postal code: "+postalCode+", Known as:"+ knownName;
        return keyLocation;
    }
}
