package com.example.creatautopiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;

public class Creatingpiechart extends AppCompatActivity {


    Createlayout myobj=Createlayout.getInstance();
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatingpiechart);
        linearLayout=findViewById(R.id.linear);


        PieChart pieChart=new PieChart(this);
        linearLayout.addView(myobj.CreatePieChart(pieChart));


    }
}