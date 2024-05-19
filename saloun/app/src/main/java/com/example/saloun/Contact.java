package com.example.saloun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Contact extends AppCompatActivity {

    LinearLayout Home, Contact, MyProfile,Services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        Home =findViewById(R.id.Home);
        Contact =findViewById(R.id.Service);
        MyProfile =findViewById(R.id.Contact);
        Services=findViewById(R.id.Service);

        Services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contact.this,Services.class);
                startActivity(intent);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contact.this,Home.class);
                startActivity(intent);
            }
        });
//        Contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Contact.this,Contact.class);
//                startActivity(intent);
//            }
//        });
        MyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contact.this,MyProfile.class);
                startActivity(intent);
            }
        });

    }
}