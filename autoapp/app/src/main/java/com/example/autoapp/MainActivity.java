package com.example.autoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Button b1;
//    EditText tx;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        b1=findViewById(R.id.but);
//        tx=findViewById(R.id.edit);

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

                    TextView tx=new TextView(this);
                    tx.setText("aditya");
                    LinearLayout li=new LinearLayout(this);

                    LinearLayout.LayoutParams lii=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                   li.setOrientation(LinearLayout.VERTICAL);
                    li.setLayoutParams(lii);
                    LinearLayout.LayoutParams txx=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    tx.setTextSize(50f);
                    tx.setGravity(View.TEXT_ALIGNMENT_CENTER);
                    tx.setLayoutParams(txx);


                    li.addView(tx);
                    setContentView(li);

//            }
//        });



    }

}