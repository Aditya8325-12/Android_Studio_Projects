package com.example.mapslocation;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapslocation.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private LocationManager locationManager;

    private  static final int requestid=201;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions

            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},requestid);

        }

        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {
                    double lat=location.getLatitude();
                    double lon=location.getLongitude();
                    LatLng latLng=new LatLng(lat,lon);
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Your Location"));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f));

                    Toast.makeText(MapsActivity.this, "sfgdfg"+String.valueOf(latLng), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    LocationListener.super.onStatusChanged(provider, status, extras);
                }

                @Override
                public void onProviderDisabled(@NonNull String provider) {
                    LocationListener.super.onProviderDisabled(provider);
                }

                @Override
                public void onProviderEnabled(@NonNull String provider) {
                    LocationListener.super.onProviderEnabled(provider);
                }
            });

        }
        else
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            {

//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
//                    @Override
//                    public void onLocationChanged(@NonNull Location location) {
//                        double lat=location.getLatitude();
//                        double lon=location.getLongitude();
//                        LatLng latLng=new LatLng(lat,lon);
//                        Toast.makeText(MapsActivity.this, ""+String.valueOf(latLng), Toast.LENGTH_SHORT).show();
//                    }
//                });

            }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        LatLng latLng=new LatLng(19.8404298,75.2182808);

    }

}