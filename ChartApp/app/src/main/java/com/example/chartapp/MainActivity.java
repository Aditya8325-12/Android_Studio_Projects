package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.PieChart);
        button2=findViewById(R.id.BarChart);
        button3=findViewById(R.id.BubbleChart);
        button4=findViewById(R.id.RadarChart);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
     switch (view.getId())
     {
         case R.id.PieChart:
             Intent intent1=new Intent(MainActivity.this,CreateAPieChart.class);
             startActivity(intent1);
             break;
         case R.id.BarChart:
             Intent intent2=new Intent(MainActivity.this,CreateABarChart.class);
             startActivity(intent2);
             break;
         case R.id.BubbleChart:
             Intent intent3=new Intent(MainActivity.this,CreateABubbleChart.class);
             startActivity(intent3);
             break;
         case R.id.RadarChart:
             Intent intent4=new Intent(MainActivity.this,CreateARadarChart.class);
             startActivity(intent4);
             break;
     }

    }
}