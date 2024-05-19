package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CreateARadarChartLayout extends AppCompatActivity {


    CreateAradarLayout myobj=CreateAradarLayout.getInstance();
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_aradar_chart_layout);

        linearLayout=findViewById(R.id.linear);
        ArrayList<RadarEntry>  radarEntries=myobj.getValues();

        RadarChart radarChart=new RadarChart(CreateARadarChartLayout.this);
        radarChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        RadarDataSet radarDataSet=new RadarDataSet(radarEntries,"");
        radarDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        radarChart.animateY(2000);
        radarChart.setData(new RadarData(radarDataSet));
        linearLayout.addView(radarChart);

    }
}