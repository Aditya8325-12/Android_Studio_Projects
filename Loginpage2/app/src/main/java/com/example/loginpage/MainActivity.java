package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    Button button1;

    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        button1=findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=text1.getText().toString();
                s2=text2.getText().toString();
                text1.setText("");
                text2.setText("");
                Toast.makeText(MainActivity.this, "Sign IN successful\n ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}