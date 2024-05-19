package com.example.dynmicalistviewa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class newActivity extends AppCompatActivity {

    Createayout myobj=Createayout.getInstance();
    LinearLayout linearLayout;
    ArrayList<String> string=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        linearLayout=findViewById(R.id.linear);
//        ArrayList<String> strings=myobj.getValues();
        ArrayList<PieEntry> pieEntries=myobj.getValues();

        PieChart pieChart=new PieChart(newActivity.this);
        pieChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setSliceSpace(5f);
        pieChart.animateY(2000);
        pieChart.setData(new PieData(pieDataSet));
        linearLayout.addView(pieChart);


//
//        ListView listView=new ListView(newActivity.this);
//        linearLayout.addView(listView);
//
//        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(newActivity.this, android.R.layout.simple_list_item_1,strings);
//        listView.setAdapter(arrayAdapter);

     }
}