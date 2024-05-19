package com.example.tastingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    FrameLayout f1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.icon:
                Intent i=new Intent(MainActivity.this,secoundpage.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.image1);
        b2=findViewById(R.id.image2);
        f1=findViewById(R.id.fragement);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.image1:
                showframe(new fragment1());
                break;
            case R.id.image2:
                showframe(new fragement1());
                break;
            case R.id.icon:



        }
    }

    public  void showframe(Fragment frame1)
    {
        FragmentManager f2=getSupportFragmentManager();
        FragmentTransaction ft=f2.beginTransaction();
        ft.replace(R.id.fragement,frame1);
        ft.commit();

    }
}