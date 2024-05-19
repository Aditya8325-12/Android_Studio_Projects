package com.example.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {


    EditText number1,number2;
    TextView result;
    Button button1,button2,button3,button4;
    double div,num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        result=findViewById(R.id.result);
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean n1= TextUtils.isEmpty(number1.getText().toString());
                boolean n2= TextUtils.isEmpty(number2.getText().toString());

                if(n1==false && n2==false )
                {
                    num1= Double.parseDouble(number1.getText().toString());
                    num2= Double.parseDouble(number2.getText().toString());
                    div=num1+num2;
                    result.setText("sum == "+div);
                }

            }
        });

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean n1= TextUtils.isEmpty(number1.getText().toString());
                boolean n2= TextUtils.isEmpty(number2.getText().toString());

                if(n1==false && n2==false )
                {
                    num1= Double.parseDouble(number1.getText().toString());
                    num2= Double.parseDouble(number2.getText().toString());
                    div=num1-num2;
                    result.setText("substraction == "+div);
                }
            }
        });
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean n1= TextUtils.isEmpty(number1.getText().toString());
                boolean n2= TextUtils.isEmpty(number2.getText().toString());

                if(n1==false && n2==false )
                {
                    num1= Double.parseDouble(number1.getText().toString());
                    num2= Double.parseDouble(number2.getText().toString());
                    div=num1/num2;
                    result.setText("division == "+div);
                }
            }
        });

        button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean n1= TextUtils.isEmpty(number1.getText().toString());
                boolean n2= TextUtils.isEmpty(number2.getText().toString());

                if(n1==false && n2==false )
                {
                    num1= Double.parseDouble(number1.getText().toString());
                    num2= Double.parseDouble(number2.getText().toString());
                    div=num1*num2;
                    result.setText("multiplication == "+div);
                }
            }
        });


    }



}