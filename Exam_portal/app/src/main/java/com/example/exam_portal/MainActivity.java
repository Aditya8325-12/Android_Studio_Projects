package com.example.exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button enter;
    EditText user,pass;
    TextView sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter=findViewById(R.id.Login);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        sign=findViewById(R.id.sign);


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,sign.class);
                startActivity(intent);
            }
        });

    }
}