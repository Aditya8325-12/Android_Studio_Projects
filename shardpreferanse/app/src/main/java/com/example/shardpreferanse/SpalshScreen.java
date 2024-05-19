package com.example.shardpreferanse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SpalshScreen extends AppCompatActivity {

    Handler handler=new Handler();

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);


        SharedPreferences sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(sharedPreferences.contains("user") || sharedPreferences.contains("pass"))
                {
                    Intent intent=new Intent(SpalshScreen.this,NewActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(SpalshScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        },500);
    }
}