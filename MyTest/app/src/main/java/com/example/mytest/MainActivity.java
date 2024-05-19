package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text,text1;
    Button  button1,button2;
    ImageView image1;

     int like=0;
     int dlike=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.hello);
        text1=findViewById(R.id.text2);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like++;
                    text.setText("NUmber of like :"+like);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlike++;
                text1.setText("Number of dislike :"+dlike);
            }
        });
    }
}