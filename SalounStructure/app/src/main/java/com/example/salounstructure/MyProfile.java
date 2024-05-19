package com.example.salounstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyProfile extends AppCompatActivity {


    LinearLayout Home, Contact, MyProfile,service;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        button=findViewById(R.id.LogOut);
        service=findViewById(R.id.Service);
        Home =findViewById(R.id.Home);
        Contact =findViewById(R.id.Contact);
        MyProfile =findViewById(R.id.MyProfile);

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyProfile.this,Services.class);
                startActivity(intent);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyProfile.this,Home.class);
                startActivity(intent);
            }
        });
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyProfile.this,Contact.class);
                startActivity(intent);
            }
        });
//        MyProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MyProfile.this,MyProfile.class);
//                startActivity(intent);
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyProfile.this,SecoundPage.class);
                startActivity(intent);
            }
        });

    }
}