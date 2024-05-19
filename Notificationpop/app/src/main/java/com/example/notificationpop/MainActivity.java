package com.example.notificationpop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String ChanleId = "mychanle";
    Notification notification;
    private static final int notificationid = 11;
    Button on, off;
    String subtext = "";

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        if (bluetoothAdapter == null) {
            Toast.makeText(this, "System is not support", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "System is supported", Toast.LENGTH_SHORT).show();
        }
        on = findViewById(R.id.on);
        off = findViewById(R.id.off);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View v) {


                if (!(bluetoothAdapter.isEnabled())) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 0);
                        return;
                    }
                    startActivityForResult(intent, 0);
                }

                subtext = "bluttoth is on";
                Createnotification(notificationManager, subtext);
                notificationManager.notify(notificationid, notification);

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
                subtext="blutooth is of";
                Createnotification(notificationManager,subtext);
                notificationManager.notify(notificationid,notification);

            }
        });

    }

    public  void Createnotification(NotificationManager notificationManager,String subtext1)
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
//                    .setLargeIcon(bitmap1)
                    .setChannelId(ChanleId)
                    .setContentText("massage")
                    .setSubText(subtext1)
                    .build();

            notificationManager.createNotificationChannel(new NotificationChannel(ChanleId,"mychanle",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("massage")
                    .setSubText(subtext1)
                    .build();
        }
    }

}