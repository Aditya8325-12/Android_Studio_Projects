package com.example.lifecycle2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity Life Cycle", "onCreate: ");
        Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity Life Cycle", "onStart: ");
        Toast.makeText(this, "onstart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity Life Cycle", "onResume: ");
        Toast.makeText(this, "onresume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity Life Cycle", "onPause: ");
        Toast.makeText(this, "onpause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity Life Cycle", "onStop: ");
        Toast.makeText(this, "onstop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity Life Cycle", "onRestart: ");
        Toast.makeText(this, "onrestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Life Cycle", "onDestroy: ");
        Toast.makeText(this, "ondestory", Toast.LENGTH_SHORT).show();
    }
}