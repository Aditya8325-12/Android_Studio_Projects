package com.example.qrcodgenrater;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {


    EditText product,value;
    Button genrate;
    ImageView qrcode;

    QRGEncoder qrgEncoder;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product=findViewById(R.id.productname);
        value=findViewById(R.id.productvalue);
        genrate=findViewById(R.id.genrate);
        qrcode=findViewById(R.id.qrcodegenrator);


        genrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}