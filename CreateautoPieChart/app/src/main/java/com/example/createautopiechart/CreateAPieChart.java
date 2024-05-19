package com.example.createautopiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CreateAPieChart extends AppCompatActivity {

    CreateALayout myobj=CreateALayout.getInstance();
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apie_chart);

        linearLayout=findViewById(R.id.linear);
        ArrayList<PieEntry> pieEntries=myobj.getValues();

        PieChart pieChart=new PieChart(CreateAPieChart.this);
        pieChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setSliceSpace(5f);
        pieChart.animateY(2000);
        pieChart.setData(new PieData(pieDataSet));
        linearLayout.addView(pieChart);

    }
}