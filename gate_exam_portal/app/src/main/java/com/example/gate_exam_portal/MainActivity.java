package com.example.gate_exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Handler handler=new Handler();
    SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPreferences.contains("user") && sharedPreferences.contains("pass"))
                {
                    Intent intent=new Intent(MainActivity.this,Home_page.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(MainActivity.this,login_page.class);
                    startActivity(intent);
                }
            }
        },500);

    }


}