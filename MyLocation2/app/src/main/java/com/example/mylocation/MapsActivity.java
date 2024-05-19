package com.example.mylocation;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mylocation.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    Toolbar toolbar;

    private LocationManager locationManager;
    private  static final int RequestId=201;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = findViewById(R.id.toolbarid);
        toolbar.setTitle("MyLocationergkl");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions

                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},RequestId);

            }
        }



        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {
                    double lat=location.getLatitude();
                    double lon=location.getLongitude();
                    LatLng latLng=new LatLng(lat,lon);
                    Log.d(TAG, String.valueOf(latLng));
                    Geocoder geocoder=new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresses=geocoder.getFromLocation(lat,lon,1);
                        String Str=addresses.get(0).getLocality()+"";
                        Str+=" , "+addresses.get(0).getCountryName();
                        Toast.makeText(MapsActivity.this, lat+","+lon, Toast.LENGTH_SHORT).show();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(Str));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {
                    double lat=location.getLatitude();
                    double lon=location.getLongitude();
                    LatLng latLng=new LatLng(lat,lon);
                    Log.d(TAG, String.valueOf(latLng));
                    Toast.makeText(MapsActivity.this, lat+","+lon, Toast.LENGTH_SHORT).show();
                    mMap.addMarker(new MarkerOptions().position(latLng).title("location "));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f));

                }
            });
        }


    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case RequestId:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
                return;
        }
    }
}