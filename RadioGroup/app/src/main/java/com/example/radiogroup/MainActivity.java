package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button enter;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter=findViewById(R.id.enter);


        radioGroup=findViewById(R.id.radio);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int check=radioGroup.getCheckedRadioButtonId();


                radioButton=findViewById(check);
                if(check==-1)
                {
                    Toast.makeText(MainActivity.this, "PLese select the option ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, ""+radioButton.getText().toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}