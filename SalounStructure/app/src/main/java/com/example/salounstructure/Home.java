package com.example.salounstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout Home, Contact, MyProfile,service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        service=findViewById(R.id.Service);
        Home =findViewById(R.id.Home);
        Contact =findViewById(R.id.Contact);
        MyProfile =findViewById(R.id.MyProfile);

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Services.class);
                startActivity(intent);
            }
        });
//        Home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Home.this,Home.class);
//                startActivity(intent);
//            }
//        });
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Contact.class);
                startActivity(intent);
            }
        });
        MyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,MyProfile.class);
                startActivity(intent);
            }
        });
    }



}