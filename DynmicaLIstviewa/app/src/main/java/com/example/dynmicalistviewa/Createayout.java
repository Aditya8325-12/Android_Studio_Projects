package com.example.dynmicalistviewa;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class Createayout {

    static  Createayout myobj=new Createayout();

    private  Createayout()
    {

    }

    public static Createayout getInstance()
    {
        if(myobj==null)
        {
            myobj=new Createayout();
        }
        return myobj;
    }

    ArrayList<EditText> EditLists=new ArrayList<>();

    public View CreateAButton(Button button1)
    {

        button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        int id=2001;
        button1.setId(id);
        button1.setText("enter");
        return button1;
    }
    public View CreateEditText(EditText editText,int i)
    {

        editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        EditLists.add(editText);
        editText.setId(i);
        editText.setHint("enter number "+i);
        return editText;
    }

    public ArrayList<PieEntry> getValues()
    {

        ArrayList<PieEntry> pieEntries=new ArrayList<>();

        for(int i=0; i < EditLists.size(); i++){
                pieEntries.add(new PieEntry(i+1,""+EditLists.get(i).getText().toString()));
        }

       return pieEntries;

    }

}
