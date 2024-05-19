package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secoundpage extends AppCompatActivity {

    Button coustomber,employee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secoundpage);

        coustomber=findViewById(R.id.cusumber);
        employee=findViewById(R.id.employee);


        coustomber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secoundpage.this,Login.class);
                startActivity(intent);
            }
        });
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secoundpage.this,Login.class);
                startActivity(intent);
            }
        });
    }
}