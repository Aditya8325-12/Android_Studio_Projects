package com.example.saloun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Services extends AppCompatActivity {
    LinearLayout Home, Contact, MyProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Home =findViewById(R.id.Home);
        Contact =findViewById(R.id.Service);
        MyProfile =findViewById(R.id.Contact);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Services.this,Services.class);
                startActivity(intent);
            }
        });
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Services.this,Contact.class);
                startActivity(intent);
            }
        });
        MyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Services.this,MyProfile.class);
                startActivity(intent);
            }
        });
    }

}