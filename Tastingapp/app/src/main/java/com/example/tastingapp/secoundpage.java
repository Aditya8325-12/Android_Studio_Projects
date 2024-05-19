package com.example.tastingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class secoundpage extends AppCompatActivity implements View.OnClickListener {

    Button b11,fadein,fadeout;
    ImageView i1;
    boolean flag=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secoundpage);

        fadein=findViewById(R.id.fadein);
        fadeout=findViewById(R.id.fadeout);
        b11=findViewById(R.id.image11);
        i1=findViewById(R.id.image123);
        b11.setOnClickListener(this);
        fadeout.setOnClickListener(this);
        fadein.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.image11:
                if(flag==true)
                {
                    i1.setImageResource(R.drawable.tracking);
                    flag=false;
                }
                else
                {
                    i1.setImageResource(R.drawable.welcome);
                    flag=true;
                }
            case R.id.fadein:
                Animation fin= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                i1.startAnimation(fin);
                break;
            case R.id.fadeout:
                Animation fout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);
                i1.startAnimation(fout);
                break;

        }
    }
}