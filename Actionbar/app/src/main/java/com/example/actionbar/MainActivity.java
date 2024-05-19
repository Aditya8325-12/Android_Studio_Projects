package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3;
    ImageView i1,i2;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b1=findViewById(R.id.button1);
            b2=findViewById(R.id.button2);
            b3=findViewById(R.id.button3);
            i1=findViewById(R.id.image1);
            i2=findViewById(R.id.image2);
            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);
            i1.setOnClickListener(this);
            i2.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.text1:
                Intent i=new Intent(MainActivity.this,target.class);
                startActivity(i);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button1:
                showf(new Fragment1());
                break;
            case R.id.button2:
                showf(new Fragment2());
                break;
            case R.id.image1:
                Intent j=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(j);
                break;

        }
    }

    private void showf(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }
}