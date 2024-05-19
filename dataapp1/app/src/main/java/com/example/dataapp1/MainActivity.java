package com.example.dataapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pieChart = findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();


    }
}