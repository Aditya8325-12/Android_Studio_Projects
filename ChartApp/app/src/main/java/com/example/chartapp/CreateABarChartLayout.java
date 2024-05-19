package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CreateABarChartLayout extends AppCompatActivity {


    CreateABarlayout myobj=CreateABarlayout.getInstance();
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_abar_chart_layout);


        linearLayout=findViewById(R.id.linear);
        ArrayList<BarEntry> barEntries=myobj.getValues();

        BarChart barChart=new BarChart(CreateABarChartLayout.this);
        barChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        BarDataSet barDataSet=new BarDataSet(barEntries,"");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(2000);
        barChart.setData(new BarData(barDataSet));
        linearLayout.addView(barChart);
    }
}