package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button2);
        b1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button2:
//                showf(new fragement1());
                Toast.makeText(this, "app is run", Toast.LENGTH_SHORT).show();
                break;
        }
    }
//    private void showf(Fragment fragement){
//        FragmentManager fa= getSupportFragmentManager();
//        FragmentTransaction ft=fa.beginTransaction();
//        ft.replace(R.id.fram,fragement);
//        ft.commit();
//    }
}