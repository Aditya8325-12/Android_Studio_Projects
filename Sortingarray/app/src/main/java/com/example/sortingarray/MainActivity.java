package com.example.sortingarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bdl,bos,balgo,bhuman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balgo=findViewById(R.id.dda);
        bdl=findViewById(R.id.dl);
        bos=findViewById(R.id.os);
        bhuman=findViewById(R.id.bhr);

        balgo.setOnClickListener(this);
        bdl.setOnClickListener(this);
        bos.setOnClickListener(this);
        bhuman.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.dda:
                Intent a=new Intent(MainActivity.this,Algo.class);
                startActivity(a);
                break;
            case R.id.dl:
                Intent b=new Intent(MainActivity.this,digitallogic.class);
                startActivity(b);
                break;
            case R.id.os:
                Intent c=new Intent(MainActivity.this,operting.class);
                startActivity(c);
                break;
            case R.id.bhr:
                Intent d=new Intent(MainActivity.this,Humanright.class);
                startActivity(d);
                break;

        }
    }
}