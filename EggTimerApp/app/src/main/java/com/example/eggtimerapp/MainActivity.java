package com.example.eggtimerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView textView;
    ImageView imageView;
    boolean start;
    CountDownTimer countDownTimer;
    long time=10*1000;
    long reminingtime=time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.text);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(start){
                    start=false;
                    b1.setText("start");
                    countDownTimer.cancel();
                }
                else
                {
                    start=true;
                    b1.setText("stop");
                    imageView.setImageResource(R.drawable.pngegg);

                    countDownTimer=new CountDownTimer(reminingtime,1000) {
                        @Override
                        public void onTick(long l) {
//                            long sec=(l/1000)%60;
//                            long minute=(l/60000)%60;
                            long milie=(l/10)%100;
                            long sec=(l/1000)%60;
                            long minute=(l/1000)/60;
                            textView.setText(minute+":"+sec+":"+milie);
//                            reminingtime=l;
                        }

                        @Override
                        public void onFinish() {
                            textView.setText("00:00:00");
                            imageView.setImageResource(R.drawable.pngegg__1_);
                            b1.animate();
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Egg is Boiled")
                                    .setMessage("Let`s Eat").show();
                            b1.setText("Reset");
                        }

                    };

                    countDownTimer.start();
                }
            }
        });

    }
}