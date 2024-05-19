package com.example.auto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.*;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText te;
    int i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.enter);
        te=findViewById(R.id.texte);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=te.getText().toString();
                 i1=Integer.parseInt(s1);

            }
        });



        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for( int i = 0; i < i1; i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(i);
            linearLayout.addView(textView);
        }
    }


}