package com.example.playergueesingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView textView,score;
    LinearLayout linearLayout,linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score=findViewById(R.id.score);
        textView=findViewById(R.id.text);
        linearLayout=findViewById(R.id.linear);


        Intent intent=getIntent();
        int  s=intent.getIntExtra("score",0);


        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(140,140);
        layoutParams.rightMargin=30;
        if(s==1 || s==2)
        {
            textView.setText("Good");
            score.setText("Score : "+s);
            ImageView imageView=new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.star);
            linearLayout.addView(imageView);

        }

        if(s==3 || s==4)
        {
            textView.setText("Very Good");
            score.setText("Score : "+s);
            for(int i=0;i<=1;i++)
            {
                textView.setText("Good");
                ImageView imageView=new ImageView(this);
                imageView.setLayoutParams(layoutParams);

                imageView.setImageResource(R.drawable.star);
                linearLayout.addView(imageView);
            }


        }
        if(s==5 || s==6)
        {
            textView.setText("Excellent ");
            score.setText("Score : "+s);


            for(int i=0;i<=2;i++)
            {
                ImageView imageView=new ImageView(this);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(R.drawable.star);
                linearLayout.addView(imageView);
            }


        }
        if(s==0)
        {
            textView.setText("Better Luck Next TIme");
            score.setText("Score : "+s);
        }


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setMessage("Do You Want To Restart  The Game ")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(result.this,MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                        }
                    }).show();

    }
}