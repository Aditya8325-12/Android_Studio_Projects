package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CreateABarChart extends AppCompatActivity implements View.OnClickListener {


    LinearLayout linearLayout1,linearLayout2,linearLayout;
    Button button;
    EditText editText;
    CreateABarlayout myObj2 =CreateABarlayout.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_abar_chart);

        button=findViewById(R.id.button);
        linearLayout1=findViewById(R.id.linear1);
        linearLayout2=findViewById(R.id.linear2);
        linearLayout=findViewById(R.id.linear);
        editText=findViewById(R.id.Edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size=Integer.parseInt(editText.getText().toString());
                for(int i=1;i<=size;i++)
                {
                    EditText editTextLabel=new EditText(CreateABarChart.this);
                    linearLayout2.addView(myObj2.CreateEditTextLabel(editTextLabel,i));

                    EditText editTextValue=new EditText(CreateABarChart.this);
                    linearLayout1.addView(myObj2.CreateEditTextValue(editTextValue,i));
                }
                Button button1=new Button(CreateABarChart.this);
                linearLayout.addView(myObj2.CreateAButton(button1));
                button1.setOnClickListener(CreateABarChart.this);
            }
        });
    }

    @Override
    public void onClick( View view) {
        switch (view.getId())
        {
            case 2001:
                Intent intent=new Intent(CreateABarChart.this,CreateABarChartLayout.class);
                startActivity(intent);
                Toast.makeText(this, "Button is created ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}