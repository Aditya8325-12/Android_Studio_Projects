package com.example.thiredpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class testresult extends AppCompatActivity {



    TextView correctAnswers,wrongAnswers;
    Button playAgain;

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testresult);


        playAgain=findViewById(R.id.playAgin);
        correctAnswers=findViewById(R.id.correct);
        wrongAnswers=findViewById(R.id.Incorrect);


        Intent intent=getIntent();
        int c=intent.getIntExtra("correct",0);
        int w=intent.getIntExtra("wrong",0);

        Toast.makeText(this, ""+c+"sdf"+w, Toast.LENGTH_SHORT).show();

        linearLayout=findViewById(R.id.linear1);


        if(c<5)
        {
            ImageView imageView=new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(100,100));
            imageView.setImageResource(R.drawable.star__2_);
            linearLayout.addView(imageView);
        }
        else
        if (c==5 || c==6 || c==7)
        {
            for(int i=0;i<2;i++)
            {

                ImageView imageView=new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(100,100));
                imageView.setImageResource(R.drawable.star__2_);
                int id=10;
                imageView.setId(id+1);
                linearLayout.addView(imageView);
            }
        }

        else if (c==8 || c==9 || c==10)
        {
            for(int i=0;i<=2;i++)
            {

                ImageView imageView=new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(100,100));
                imageView.setImageResource(R.drawable.star__2_);
                int id=10;
                imageView.setId(id+1);
                linearLayout.addView(imageView);
            }
        }

//        set the correct value
        correctAnswers.setText(""+c);
        wrongAnswers.setText(""+w);

//        back button

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(testresult.this,Home.class);
                startActivity(intent);
            }
        });

    }

}