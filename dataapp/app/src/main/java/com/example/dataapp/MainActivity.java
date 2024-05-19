package com.example.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;

    String[] data={"A","B","C","D"};
    int[] value={200,500,100,600};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pieChart = findViewById(R.id.pieChart);
        getEntries();
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(20f);
    }
    private void getEntries() {
        pieEntries = new ArrayList<>();

        for (int i=0;i<data.length;i++)
        {
            pieEntries.add(new PieEntry(value[i], data[i]));
        }
//        pieEntries.add(new PieEntry(20f, 0));
//        pieEntries.add(new PieEntry(20f, 1));
//        pieEntries.add(new PieEntry(20f, 2));
//        pieEntries.add(new PieEntry(20f, 3));
    }
}