package com.example.adityabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    int count=0;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linear);



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                    Intent intent=new Intent(MainActivity.this,SecoundPage.class);
                    startActivity(intent);

            }
        },4000);





    }
}