package com.example.thiredpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences=getSharedPreferences("mypre",MODE_PRIVATE);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences.Editor edit=sharedPreferences.edit();
                if(sharedPreferences.contains("user") && sharedPreferences.contains("phone")   )
                {
                    Intent intent=new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }
                else if(!sharedPreferences.contains("user") && !sharedPreferences.contains("phone")   )
                {
                    Intent intent=new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
                }

            }
        },500);
    }
}