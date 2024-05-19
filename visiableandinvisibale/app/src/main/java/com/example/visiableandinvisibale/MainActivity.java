package com.example.visiableandinvisibale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;

    boolean value=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.text);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(value)
                {
                    value=false;
                    text.setVisibility(View.INVISIBLE);
                    button.setText("show");
                }
                else
                {
                    value=true;
                    text.setVisibility(View.VISIBLE);
                    button.setText("Hide");
                }
            }
        });
    }
}