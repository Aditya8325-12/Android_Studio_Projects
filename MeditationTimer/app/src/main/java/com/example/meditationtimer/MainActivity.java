package com.example.meditationtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.text);

        CountDownTimer countDownTimer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {

                long sec=l/1000;
                textView.setText(sec+"");
            }

            @Override
            public void onFinish() {
                textView.setText("0");
                Toast.makeText(MainActivity.this, "Meditation is Done ", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}