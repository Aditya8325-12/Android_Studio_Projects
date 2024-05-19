package com.example.hakerswatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationManager;
    TextView lati, loni, alii, location1;

    private  static final int requestid=201;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lati = findViewById(R.id.lat);
        loni = findViewById(R.id.longi);
        alii = findViewById(R.id.alt);
        location1 = findViewById(R.id.location);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},requestid);
            }
        }

        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {

                    String lat= String.valueOf(location.getLatitude());
                    String lon= String.valueOf(location.getLongitude());
                    String alt= String.valueOf(location.getAltitude());

                    Geocoder geocoder=new Geocoder(getApplicationContext());
                    try {
                        List<Address> address=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        String str=address.get(0).getLocality();
                        str+=" , "+address.get(0).getCountryName();

                        lati.setText("Latitude : "+lat);
                        loni.setText("Longitude : "+lon);
                        alii.setText("Altitude : "+alt);
                        location1.setText("Address : "+str);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
   }
   else
       if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
       {

           locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
               @Override
               public void onLocationChanged(@NonNull Location location) {

                   String lat= String.valueOf(location.getLatitude());
                   String lon= String.valueOf(location.getLongitude());
                   String alt= String.valueOf(location.getAltitude());

                   Geocoder geocoder=new Geocoder(getApplicationContext());
                   try {
                       List<Address> address=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                       String str=address.get(0).getLocality();
                       str+=" , "+address.get(0).getCountryName();

                       lati.setText("Latitude : "+lat);
                       loni.setText("Longitude : "+lon);
                       alii.setText("Altitude : "+alt);
                       location1.setText("Address : "+str);

                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           });
       }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case requestid:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
        }
    }
}