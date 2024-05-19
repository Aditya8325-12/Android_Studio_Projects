package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class textviews extends AppCompatActivity {


    EditText editText;
    String days;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviews);
        editText=findViewById(R.id.edittext);

        Intent intent=getIntent();

        sharedPreferences=getSharedPreferences("My-pre",MODE_PRIVATE);

        days=intent.getStringExtra("positions");


        if(sharedPreferences.contains("days"))
        {
            editText.setText(sharedPreferences.getString(days,null));
        }


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}