package com.example.dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class stack extends AppCompatActivity implements  View.OnClickListener {




    //xml
    Button enter,push,pop;
    EditText number;
    TextView i0,i1,i2,i3,i4,i5;
    LinearLayout linearLayout;

    int[] array=new int[6];
    int top=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        linearLayout=findViewById(R.id.linear1);

        push=findViewById(R.id.push);
        pop=findViewById(R.id.pop);
        enter=findViewById(R.id.enter);
        number=findViewById(R.id.number);
        i0=findViewById(R.id.i0);
        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i3=findViewById(R.id.i3);
        i4=findViewById(R.id.i4);
        i5=findViewById(R.id.i5);

        push.setOnClickListener(this);
        pop.setOnClickListener(this);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input=Integer.parseInt(number.getText().toString());
                pushfunction(input);
                number.setText("");
                linearLayout.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.push:
                linearLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.pop:
                popfunction();
                break;
        }
    }



    public  void pushfunction(int input)
    {

        if(top==array.length)
        {
            Toast.makeText(this, "stack is full", Toast.LENGTH_SHORT).show();
        }
        else if(top==0)
        {
            array[top]=input;

            if(top==0)
            {
                i0.setText(""+input);
            }
            top++;
        }
        else{
            array[top]=input;
            if(top==1)
            {
                i1.setText(""+input);
            }
            if(top==2)
            {
                i2.setText(""+input);
            }
            if(top==3)
            {
                i3.setText(""+input);
            }
            if(top==4)
            {
                i4.setText(""+input);
            }
            if(top==5)
            {
                i5.setText(""+input);
            }
            top++;
        }
    }


    public void popfunction(){
        if(top==0)
        {
            i0.setText("");
            Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(top==1)
            {
                i1.setText("");
            }
            if(top==2)
            {
                i2.setText("");
            }
            if(top==3)
            {
                i3.setText("");
            }
            if(top==4)
            {
                i4.setText("");
            }
            if(top==5)
            {
                i5.setText("");
            }

            top--;
        }

    }
}