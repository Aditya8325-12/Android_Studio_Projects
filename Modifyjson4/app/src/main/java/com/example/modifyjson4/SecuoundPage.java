package com.example.modifyjson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecuoundPage extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secuound_page);

        textView=findViewById(R.id.textview);

        Intent intent=new Intent(SecuoundPage.this,MainActivity.class);
        String s=intent.getStringExtra("jsonData");

        textView.setText("s"+s);
    }

}