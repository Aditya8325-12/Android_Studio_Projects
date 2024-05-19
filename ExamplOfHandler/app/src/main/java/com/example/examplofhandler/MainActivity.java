package com.example.examplofhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    boolean value;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.Button);
        textView=findViewById(R.id.textview);
        textView.setText("0:59:59");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(value)
                {
                    value=false;
                    textView.setText("00:00");
                    countDownTimer.cancel();

                }
                else
                {
                    value=true;

                    countDownTimer=new CountDownTimer(60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            long hour = (millisUntilFinished / 3600000) % 24;
                            long min = (millisUntilFinished / 60000) % 60;
                            long sec = (millisUntilFinished / 1000) % 60;
                            textView.setText( hour+":"+min+":"+sec);
                        }

                        @Override
                        public void onFinish() {

                            Toast.makeText(MainActivity.this, "time Is Completed", Toast.LENGTH_SHORT).show();
                            countDownTimer.start();

                        }
                    };

                }

            }
        });






//        Handler handler=new Handler();
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if(sec>0)
//                {
//                    sec--;
//                    handler.postDelayed(this,2000);
//                    Toast.makeText(MainActivity.this, "sec"+sec, Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//
//                    Toast.makeText(MainActivity.this, "Time will Finish", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });




    }
}