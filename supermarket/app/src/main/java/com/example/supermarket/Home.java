package com.example.supermarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    Button scanbtn;
    public static TextView scantext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         drawerLayout=findViewById(R.id.drawar);
         Toolbar toolbar=findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         actionBarDrawerToggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
         drawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();



         navigationView=findViewById(R.id.navview);
         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 switch (item.getItemId())
                 {
                     case R.id.home:
                         Intent intent=new Intent(getApplicationContext(),Login.class);
                         startActivity(intent);
                 }

                 return true;
             }
         });


        scantext=(TextView)findViewById(R.id.scantext);
        scanbtn=(Button) findViewById(R.id.scanbtn);

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),scanerview.class));
            }
        });


    }

}