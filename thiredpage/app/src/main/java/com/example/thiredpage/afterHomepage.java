package com.example.thiredpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class afterHomepage extends AppCompatActivity {

    Button PYQC,PYQCFinal,Final;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_homepage);


        PYQC=findViewById(R.id.PYQC);
        PYQCFinal=findViewById(R.id.PYQCFinal);
        Final=findViewById(R.id.Final);

        PYQC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(afterHomepage.this, testlist.class);
                intent.putExtra("previousquestion",1);
                startActivity(intent);
            }
        });

        PYQCFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(afterHomepage.this, testlist.class);
                intent.putExtra("previousquestion",2);
                startActivity(intent);
            }
        });

        Final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(afterHomepage.this, testlist.class);
                intent.putExtra("previousquestion",3);
                startActivity(intent);
            }
        });




    }
}