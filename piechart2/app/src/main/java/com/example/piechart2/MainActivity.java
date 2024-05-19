package com.example.piechart2;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart piecchart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        piecchart=findViewById(R.id.piechart);

//        getEnteries();
        String[] s={"a","b","c","d"};
        ArrayList<PieEntry> pieEntries=new ArrayList<>();
        for(int i=1;i<5;i++)
        {
            float value=(float)(i*10.0);
            PieEntry pieEntry=new PieEntry(i,value);
            pieEntries.add(pieEntry);
        }

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        piecchart.setData(new PieData(pieDataSet));


    }
//
//    public  void getEnteries(){
//
//
//    }

}