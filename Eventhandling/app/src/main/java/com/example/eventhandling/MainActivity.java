package com.example.eventhandling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MainActivity<like> extends AppCompatActivity implements View.OnClickListener {

        AppCompatImageView like,dislike;
        TextView textview1,textview2;

        int lcount=0;
        int dcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            like.findViewById(R.id.like);
            dislike.findViewById(R.id.dislike);
            textview1.findViewById(R.id.text1);
            textview2.findViewById(R.id.text2);
            like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lcount++;
                textview1.setText("Number of like :"+lcount);
            }
        });
            dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 dcount++;
                textview2.setText("Number of dislike :"+dcount);
            }
        });


    }

}