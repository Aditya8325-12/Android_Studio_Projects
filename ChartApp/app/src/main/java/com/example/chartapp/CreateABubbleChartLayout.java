package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CreateABubbleChartLayout extends AppCompatActivity {


    CreateABubbleLayout myobj=CreateABubbleLayout.getInstance();
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_abubble_chart_layout);

        linearLayout=findViewById(R.id.linear);
        ArrayList<BubbleEntry> bubbleEntries =myobj.getValues();

        BubbleChart bubbleChart=new BubbleChart(CreateABubbleChartLayout.this);
        bubbleChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        BubbleDataSet bubbleDataSet=new BubbleDataSet(bubbleEntries,"");
        bubbleDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        bubbleChart.animateY(2000);
        bubbleChart.setData(new BubbleData(bubbleDataSet));
        linearLayout.addView(bubbleChart);
    }
}