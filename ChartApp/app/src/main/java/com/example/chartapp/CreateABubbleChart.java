package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CreateABubbleChart extends AppCompatActivity  implements View.OnClickListener {


    LinearLayout linearLayout;
    Button button;
    EditText editText;
    CreateABubbleLayout myObj3=CreateABubbleLayout.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_abubble_chart);


        button=findViewById(R.id.button);
        linearLayout=findViewById(R.id.linear);
        editText=findViewById(R.id.Edittext);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size=Integer.parseInt(editText.getText().toString());
                for(int i=1;i<=size;i++)
                {

                    EditText editTextValue=new EditText(CreateABubbleChart.this);
                    linearLayout.addView(myObj3.CreateEditTextValue(editTextValue,i));
                }
                Button button1=new Button(CreateABubbleChart.this);
                linearLayout.addView(myObj3.CreateAButton(button1));
                button1.setOnClickListener(CreateABubbleChart.this);
            }
        });

    }

    @Override
    public void onClick( View view) {
        switch (view.getId())
        {
            case 2001:
                Intent intent=new Intent(CreateABubbleChart.this,CreateABubbleChartLayout.class);
                startActivity(intent);
                Toast.makeText(this, "Button is created ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}