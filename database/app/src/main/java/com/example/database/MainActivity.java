package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button p,t,b,c;
TextView te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p=findViewById(R.id.pie);
        t=findViewById(R.id.table);
        b=findViewById(R.id.bar);
        c=findViewById(R.id.column);

        p.setOnClickListener(this);
        t.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.pie:
                te.setText("pie");
                break;
            case R.id.bar:
                te.setText("bar");
                break;
            case R.id.table:
                te.setText("table");
                break;
            case R.id.column:
                te.setText("column");
                break;
        }
    }
}