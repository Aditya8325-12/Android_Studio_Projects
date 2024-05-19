package com.example.janmarashi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText name;
    DatePicker dob;
    Button enter;
    String date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        dob=findViewById(R.id.datePicker);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dob.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                         date1=i+"/"+i1+"/"+i2;
                }
            });
        }
        enter=findViewById(R.id.enter);



        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1=name.getText().toString();
                Intent intent=new Intent(MainActivity.this,rashishow.class);
                intent.putExtra("name",name1);
                intent.putExtra("dob",date1);
                startActivity(intent);
            }
        });
    }
}