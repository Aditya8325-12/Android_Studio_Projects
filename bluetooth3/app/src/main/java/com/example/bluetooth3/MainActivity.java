package com.example.bluetooth3;

import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    Button on, off, devises, visable;
    BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> pair;

    ListView listView;
    private static final int Reqestid = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on = findViewById(R.id.on);
        off = findViewById(R.id.off);
        devises = findViewById(R.id.devise);
        visable = findViewById(R.id.visable);

        listView = findViewById(R.id.listview);
        bluetoothAdapter = getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "System is not support", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "System is support", Toast.LENGTH_SHORT).show();
        }

        on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (!(bluetoothAdapter.isEnabled())) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 0);
                        return;
                    }
                    startActivityForResult(intent, 0);
                    Toast.makeText(MainActivity.this, "turn on ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "offf", Toast.LENGTH_SHORT).show();
                }

            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 0);
                    return;
                }
                bluetoothAdapter.disable();

            }
        });


        visable.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_ADVERTISE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.BLUETOOTH_ADVERTISE},0);
                    return;
                }
                startActivityForResult(intent, 0);

            }
        });

        devises.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT},0);
                    return;
                }
                pair = bluetoothAdapter.getBondedDevices();
                ArrayList<String> arrayList=new ArrayList<>();
                arrayList.add("afsdf");
                for(BluetoothDevice pair:pair)
                {
                    arrayList.add(pair.getName());
                }

               ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(arrayAdapter);
            }
        });
    }
}
