package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    SeekBar seekBar;

    int count =0;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.text);
        seekBar=findViewById(R.id.Seekbar);



        countDownTimer= new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                long sec=l/1000;
                count++;
                seekBar.setProgress(count);
                textView.setText("sec : "+sec);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time is End ", Toast.LENGTH_SHORT).show();
            }
        }.start();

    }
}