package com.example.statickpiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button EnterButton;
    EditText v1,v2,v3,v4,v5,l1,l2,l3,l4,l5;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterButton=findViewById(R.id.Enterbutton);
        v1=findViewById(R.id.value1);
        v2=findViewById(R.id.value2);
        v3=findViewById(R.id.value3);
        v4=findViewById(R.id.value4);
        v5=findViewById(R.id.value5);
        l1=findViewById(R.id.label1);
        l2=findViewById(R.id.label2);
        l3=findViewById(R.id.label3);
        l4=findViewById(R.id.label4);
        l5=findViewById(R.id.label5);
        pieChart=findViewById(R.id.pieChart);
        EnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<PieEntry> pieEntries=new ArrayList<>();
                pieEntries.add(new PieEntry(Float.parseFloat(v1.getText().toString()),l1.getText().toString()));
                pieEntries.add(new PieEntry(Float.parseFloat(v2.getText().toString()),l2.getText().toString()));
                pieEntries.add(new PieEntry(Float.parseFloat(v3.getText().toString()),l3.getText().toString()));
                pieEntries.add(new PieEntry(Float.parseFloat(v4.getText().toString()),l4.getText().toString()));
                pieEntries.add(new PieEntry(Float.parseFloat(v5.getText().toString()),l5.getText().toString()));
                PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                pieDataSet.setSliceSpace(10f);
                pieDataSet.setValueTextSize(10f);
                pieChart.setData(new PieData(pieDataSet));
                pieChart.animateY(2000);
            }
        });
    }
}