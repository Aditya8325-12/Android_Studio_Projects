package com.example.janmarashi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rashishow extends AppCompatActivity {


    TextView name,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rashishow);

        name=findViewById(R.id.username);
        date=findViewById(R.id.dob);
        Intent intent=getIntent();
        Toast.makeText(this, intent.getStringExtra("name")+"=="+intent.getStringExtra("dob"), Toast.LENGTH_SHORT).show();
        name.setText(""+intent.getStringExtra("name"));
        date.setText(""+intent.getStringExtra("dob"));


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/dd/MM");

        try {
            Date strDate = sdf.parse(String.valueOf(date));
            Date
        } catch (ParseException e) {

            e.printStackTrace();
        }


    }
}