package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {


    GridView grid;

     int image[]={
                R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5,
             R.drawable.l5

     };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=findViewById(R.id.gridview);

        grid.setAdapter(new gridadapter(image,this));
    }
}