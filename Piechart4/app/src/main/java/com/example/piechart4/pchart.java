package com.example.piechart4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

class  miniPchart{

    public  void Creatingtextviews(int n,LinearLayout linearLayout,EditText editText,ArrayList<EditText> editTexts)
    {
        for(int creatingtextviews=1;creatingtextviews<=n;creatingtextviews++)
        {

            editText.setLayoutParams(new LinearLayout.LayoutParams(800,LinearLayout.LayoutParams.WRAP_CONTENT));
            editText.setHint("enter no "+creatingtextviews);
            editTexts.add(editText);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            editText.setId(creatingtextviews);
            linearLayout.addView(editText);
        }

    }

    public void CreatingButton(LinearLayout linearLayout,Button button)
    {

        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        button.setText("enter");
        int ii=100;
        button.setId(100+ii);
        button.setBackgroundColor(Color.BLUE);
//        button.setOnClickListener((View.OnClickListener) this);
        linearLayout.addView(button);
    }
}

public class pchart extends AppCompatActivity implements View.OnClickListener {

    miniPchart miniPchart=new miniPchart();
    Button button;
    EditText editText;
    LinearLayout linearLayout;
    ArrayList<EditText> editTexts=new ArrayList<>();
    ArrayList<String> strings=new ArrayList<>();
    creatingpiechart creatingpiechart=new creatingpiechart(linearLayout);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pchart);
        button=findViewById(R.id.enter);
        editText=findViewById(R.id.edit);
        linearLayout=findViewById(R.id.linear);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.enter:

                Boolean value= TextUtils.isEmpty(editText.getText().toString());

                if(value==true)
                {
                    editText.setError("please fill the value");
                }
                else{
                    int i=Integer.parseInt(editText.getText().toString());

                    EditText editText=new EditText(this);
                    //creating text view
                    miniPchart.Creatingtextviews(i,linearLayout,editText,editTexts);

                    Button button=new Button(this);
                    //creating Button
                    miniPchart.CreatingButton(linearLayout,button);
                }
                break;
            case 200:
                int size=editTexts.size();
                for(int i=0;i<size;i++)
                {
                    strings.add(editTexts.get(i).getText().toString());
                    editTexts.get(i).setText("0");
                }
                Intent intent=new Intent(pchart.this,creatingpiechart.class);
                Toast.makeText(this, "aditya dhutraj", Toast.LENGTH_SHORT).show();
                break;

        }
    }

}