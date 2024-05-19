package com.example.exam_portal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Test_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);

        Intent intent=getIntent();

        int correct=intent.getIntExtra("correct",0);
        int wrong=intent.getIntExtra("wrong",0);


        Toast.makeText(this, "correct == "+correct +"\n wrong == "+wrong, Toast.LENGTH_SHORT).show();
    }
}