package com.example.autopiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linear);





        //creating pie chart

        PieChart pieChart=new PieChart(this);
        pieChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        ArrayList<PieEntry> Pieenters=new ArrayList<>();

        Pieenters.add(new PieEntry(200, "jan"));
        Pieenters.add(new PieEntry(100, "Feb"));
        Pieenters.add(new PieEntry(500, "march"));
        Pieenters.add(new PieEntry(300, "april"));
        Pieenters.add(new PieEntry(120, "may"));
        Pieenters.add(new PieEntry(80, "jun"));


        PieDataSet pieDataSet=new PieDataSet(Pieenters,"");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.getValueTextColor();
        pieDataSet.setSliceSpace(5f);
        pieChart.animateY(2000);
        pieChart.setData(new PieData(pieDataSet));
        linearLayout.addView(pieChart);



        //creating bar chart

        BarChart barChart=new BarChart(this);
        barChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));
        ArrayList<BarEntry> barEntries=new ArrayList<>();

//
//        for(int creatingpieentry=1;creatingpieentry<=5;creatingpieentry++){
//            float value=(float) (creatingpieentry*10.0);
//            BarEntry barEntry=new BarEntry(creatingpieentry,value);
//            barEntries.add(barEntry);
//        }

        barEntries.add(new BarEntry("dfsd",123));
        barEntries.add(new BarEntry(2015,456));
        barEntries.add(new BarEntry(2016,789));
        barEntries.add(new BarEntry(2017,963));
        barEntries.add(new BarEntry(2018,852));
        barEntries.add(new BarEntry(2019,741));
        barEntries.add(new BarEntry(2020,711));
        barEntries.add(new BarEntry(2021,159));

        BarDataSet barDataSet=new BarDataSet(barEntries,"");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        BarData barData=new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.animateY(2000);

        linearLayout.addView(barChart);


        //creatig raderchart
        RadarChart radarChart=new RadarChart(this);
        radarChart.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));

        ArrayList<RadarEntry> radarEntries=new ArrayList<>();
        for(int creatingraderchart=1;creatingraderchart<=5;creatingraderchart++)
        {
            float value=(float) (creatingraderchart*10.0);
            RadarEntry radarEntry=new RadarEntry(creatingraderchart,value);
            radarEntries.add(radarEntry);
        }


        RadarDataSet radarDataSet=new RadarDataSet(radarEntries,"");
        radarDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        radarChart.setData(new RadarData(radarDataSet));
        linearLayout.addView(radarChart);





        //creating Bubblechart

        BubbleChart bubbleChart=new BubbleChart(this);
        bubbleChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        ArrayList<BubbleEntry> bubbleEntries=new ArrayList<>();
        for(int creatinbubbleenteries=1;creatinbubbleenteries<5;creatinbubbleenteries++)
        {
            float value=(float) (creatinbubbleenteries*10.0);
            int x=creatinbubbleenteries-1;
            BubbleEntry bubbleEntry=new BubbleEntry(x,creatinbubbleenteries,value);
            bubbleEntries.add(bubbleEntry);
        }

        BubbleDataSet bubbleDataSet=new BubbleDataSet(bubbleEntries,"");
        bubbleDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        BubbleData bubbleData=new BubbleData(bubbleDataSet);
        bubbleChart.setData(bubbleData);
        linearLayout.addView(bubbleChart);
    }
}