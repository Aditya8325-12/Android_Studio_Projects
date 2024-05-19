package com.example.chartapp;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class CreateABarlayout {
    static  CreateABarlayout myobj=new CreateABarlayout();
    private CreateABarlayout()
    {

    }

    public static CreateABarlayout getInstance()
    {
        if(myobj==null)
        {
            myobj=new CreateABarlayout();
        }
        return myobj;
    }


    ArrayList<EditText> EditLabelLists=new ArrayList<>();
    ArrayList<EditText> EditValueLists=new ArrayList<>();

    public View CreateAButton(Button button1)
    {

        button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        int id=2001;
        button1.setId(id);
        button1.setText("enter");
        return button1;
    }
    public View CreateEditTextLabel(EditText editText,int i)
    {
        editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        EditLabelLists.add(editText);
        editText.setId(i);
        editText.setHint("enter Label "+i);
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        return editText;
    }
    public View CreateEditTextValue(EditText editText,int i)
    {

        editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        EditValueLists.add(editText);
        editText.setId(i);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setHint("enter value "+i);
        return editText;
    }

    public ArrayList<BarEntry> getValues()
    {

        ArrayList<BarEntry> barEntries=new ArrayList<>();

        for(int i=0; i < EditLabelLists.size(); i++){

            BarEntry barEntry =new BarEntry(Float.parseFloat(EditValueLists.get(i).getText().toString()), Float.parseFloat(EditLabelLists.get(i).getText().toString()));
            barEntries.add(barEntry);
        }

        return barEntries;

    }
}
