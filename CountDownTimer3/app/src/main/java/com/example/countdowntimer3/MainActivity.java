package com.example.countdowntimer3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        TextView textView;
        Button b1;
        CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    countDownTimer=new CountDownTimer(10000,100) {
                        @Override
                        public void onTick(long l) {
                            long sec=l/1000;
                            long min=l/10;
                            long hour=l/1000;
                            textView.setText("sec"+sec);

                        }
                        @Override
                        public void onFinish() {
                            Toast.makeText(MainActivity.this, "Time is Completed", Toast.LENGTH_SHORT).show();

                        }
             }.start();
            }
        });


    }




}