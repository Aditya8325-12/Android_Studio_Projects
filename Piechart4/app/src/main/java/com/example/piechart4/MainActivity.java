package com.example.piechart4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;

    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linear);

//        assign variable to ui element
        button1=findViewById(R.id.PieChart);
        button2=findViewById(R.id.BarChart);
        button3=findViewById(R.id.RadarChart);
        button4=findViewById(R.id.BubbleChart);

//creating on click Listener
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.PieChart:
                Intent intent4=new Intent(MainActivity.this,pchart.class);
                startActivity(intent4);
                break;
            case R.id.BarChart:
                Intent intent1=new Intent(MainActivity.this,BarChart.class);
                startActivity(intent1);
                break;
            case R.id.BubbleChart:
                Intent intent2=new Intent(MainActivity.this,BubbleChart.class);
                startActivity(intent2);
                break;
            case R.id.RadarChart:
                Intent intent3=new Intent(MainActivity.this,RadarChart.class);
                startActivity(intent3);
                break;

        }
    }
}