package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Target extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        text1=findViewById(R.id.text);
        Intent i=getIntent();
        String str=i.getStringExtra("result");
        text1.setText(str);

    }
}