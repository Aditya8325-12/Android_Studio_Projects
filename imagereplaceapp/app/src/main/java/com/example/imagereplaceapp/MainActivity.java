package com.example.imagereplaceapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    Button b1;
    boolean value;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.but);
        i1=findViewById(R.id.image);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(value)
                {
                    i1.setImageResource(R.drawable.play);
                }
                if(!value)
                {
                    i1.setImageResource(R.drawable.pause_button__1_);
                }

                value=!value;
            }
        });
    }
}