package com.sujan.googlemapdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLocations(View view) {
        intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void locateMe(View view) {
        intent = new Intent(this, LocateMe.class);
        startActivity(intent);
    }

  /*  public void getMyLocation(View view) {
        intent = new Intent(this, GetMyLocation.class);
        startActivity(intent);
    }*/
}
