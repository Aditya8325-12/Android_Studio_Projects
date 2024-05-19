package com.example.chartapp;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class CreateABubbleLayout {

    static  CreateABubbleLayout myobj=new CreateABubbleLayout();

    private CreateABubbleLayout()
    {

    }

    public static CreateABubbleLayout getInstance()
    {
        if(myobj==null)
        {
            myobj=new CreateABubbleLayout();
        }
        return myobj;
    }



    ArrayList<EditText> EditValueLists=new ArrayList<>();

    public View CreateAButton(Button button1)
    {

        button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        int id=2001;
        button1.setId(id);
        button1.setText("enter");
        return button1;
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

    public ArrayList<BubbleEntry> getValues()
    {

        ArrayList<BubbleEntry> bubbleEntries=new ArrayList<>();

        for(int i=0; i < EditValueLists.size(); i++){

            int value= (int) (Integer.parseInt(EditValueLists.get(i).getText().toString())* 0.10);
            BubbleEntry bubbleEntry=new BubbleEntry(i,i+1,value);
            bubbleEntries.add(bubbleEntry);
        }

        return bubbleEntries;

    }

}
