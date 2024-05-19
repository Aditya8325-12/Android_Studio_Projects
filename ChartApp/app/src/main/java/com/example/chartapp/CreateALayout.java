package com.example.chartapp;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class CreateALayout {

    static  CreateALayout myobj=new CreateALayout();

    private CreateALayout()
    {

    }

    public static CreateALayout getInstance()
    {
        if(myobj==null)
        {
            myobj=new CreateALayout();
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

    public ArrayList<PieEntry> getValues()
    {

        ArrayList<PieEntry> pieEntries=new ArrayList<>();

        for(int i=0; i < EditLabelLists.size(); i++){

            PieEntry pieEntry=new PieEntry(Float.parseFloat(EditValueLists.get(i).getText().toString()),EditLabelLists.get(i).getText().toString());
            pieEntries.add(pieEntry);
        }

        return pieEntries;

    }



}
