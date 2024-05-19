package com.example.creatautopiechart;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Createlayout {

    static Createlayout myobj=new Createlayout();

    ArrayList<EditText> editTexts=new ArrayList<>();

    private Createlayout()
    {

    }

    public static Createlayout getInstance()
    {
        if(myobj==null)
        {
            myobj=new Createlayout();
        }
        return myobj;
    }


    public View CreateEditTextViews(EditText editText, int id)
    {
        editText.setLayoutParams(new LinearLayout.LayoutParams(800,LinearLayout.LayoutParams.WRAP_CONTENT));
        editText.setHint("enter no "+id);
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setId(100+id);
        editTexts.add(editText);
        return editText;
    }

    public View CreateButtonView(Button button)
    {
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        int id=100;
        button.setId(100+id);
        button.setText("Enter");
        return button;

    }


    public View CreatePieChart(PieChart pieChart)
    {
        pieChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));
        ArrayList<PieEntry> pieEntries=new ArrayList<>();


        for(int i=1;i<=editTexts.size();i++)
        {
            final float[] value = new float[1];
            editTexts.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        value[0] =(float) (Integer.parseInt(String.valueOf(charSequence)));
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            pieEntries.add(new PieEntry(i,value[0]));
        }


        for(int i=0;i<=editTexts.size();i++)
        {
            float value=(float)(i*1.00);
            pieEntries.add(new PieEntry(i,value));
        }



        PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setData(new PieData(pieDataSet));
        return pieChart;
    }
}

