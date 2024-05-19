package com.example.piechart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AnyChartView p;
    String[] data={"jan","feb","mar"};
    int[] ear={111,150,130};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=findViewById(R.id.pi);

        setuppi();
    }
    public void setuppi()
    {
        List<DataEntry> ldata=  new ArrayList<>();
        Pie po= AnyChart.pie();

        for(int i=0;i<data.length;i++)
        {
            ldata.add(new ValueDataEntry(data[i],ear[i]));
        }
        po.data(ldata);
        p.setChart(po);

    }

}