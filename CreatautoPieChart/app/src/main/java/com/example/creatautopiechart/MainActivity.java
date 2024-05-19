package com.example.creatautopiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    Button button;
    EditText editText;
    Createlayout myobj=Createlayout.getInstance();




    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.linear);
        button=findViewById(R.id.enter);
        editText=findViewById(R.id.edittext);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.enter:
                boolean editTextValueIsEmpty= TextUtils.isEmpty(editText.getText().toString());
                if(editTextValueIsEmpty==true)
                {
                    editText.setError("Please fill the value");
                }
                else
                {
                    int HowManyCreatedEditText=Integer.parseInt(editText.getText().toString());
                    for(int i=1;i<=HowManyCreatedEditText;i++)
                    {
                        EditText editText=new EditText(this);

                            linearLayout.addView(myobj.CreateEditTextViews(editText,i));
                    }

                    Button button=new Button(this);
                    button.setOnClickListener(this);
                    linearLayout.addView(myobj.CreateButtonView(button));

                }
                break;
            case 200:
                Intent intent=new Intent(MainActivity.this,Creatingpiechart.class);
                startActivity(intent);
                break;
        }
    }
}