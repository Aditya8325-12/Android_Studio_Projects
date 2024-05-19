package com.example.piechart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.github.mikephil.charting.charts.PieChart;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linear);

        PieChart pieChart=new PieChart(this);
        pieChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        ArrayList<PieEntry> pieEntries=new ArrayList<PieEntry>();







    }
}