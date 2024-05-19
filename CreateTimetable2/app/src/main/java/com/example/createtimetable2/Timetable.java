package com.example.createtimetable2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Timetable extends AppCompatActivity {

    EditText editText;
    String days;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        editText=findViewById(R.id.Edittext);

         sharedPreferences=getSharedPreferences("My-pre",MODE_PRIVATE);
        Intent intent=getIntent();
        days=intent.getStringExtra("position");

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
                    SharedPreferences.Editor edit=sharedPreferences.edit();
                   edit.putString(days,String.valueOf(charSequence));
                    edit.commit();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });


    }
}