package com.example.sharedpreferanse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.start);

         sharedPreferences=getSharedPreferences("my-re",MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor edit=sharedPreferences.edit();
                if(sharedPreferences.contains("user") && sharedPreferences.contains("phone")   )
                {
                    String user=sharedPreferences.getString("user","");
                    String phone=sharedPreferences.getString("phone","");

                    Toast.makeText(MainActivity.this, "user : " +user+"phone :"+phone, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,home.class);
                    startActivity(intent);
                }
                else if(!sharedPreferences.contains("user") && !sharedPreferences.contains("phone")   )
                {
                    String user=sharedPreferences.getString("user","");
                    String phone=sharedPreferences.getString("phone","");

                    Toast.makeText(MainActivity.this, "user : " +user+"phone :"+phone, Toast.LENGTH_SHORT).show();


                    Intent intent=new Intent(MainActivity.this,Secoundpage.class);
                    startActivity(intent);
                }
            }
        });
    }
}