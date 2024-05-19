package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,add,sub,mul,div;
    TextView text;

    int num1,num2;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.b1);
        sub=findViewById(R.id.b2);
        mul=findViewById(R.id.b3);
        div=findViewById(R.id.b4);
        b1=findViewById(R.id.b5);
        b2=findViewById(R.id.b6);
        b3=findViewById(R.id.b7);
        b4=findViewById(R.id.b8);
        b5=findViewById(R.id.b9);
        b6=findViewById(R.id.b10);
        b7=findViewById(R.id.b11);
        b8=findViewById(R.id.b12);
        b9=findViewById(R.id.b13);
        b0=findViewById(R.id.b14);
        text=findViewById(R.id.view);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="+";
                text.setText(s);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="-";
                text.setText(s);
            }

        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="*";
                text.setText(s);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="/";
                text.setText(s);
            }
        });




    }
}