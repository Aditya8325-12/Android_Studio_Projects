package com.example.fragmentonclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    BlankFragment blankFragment=new BlankFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    frameLayout=findViewById(R.id.frame);

        FragmentManager fragment=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragment.beginTransaction();
        fragmentTransaction.replace(R.id.frame,blankFragment);
        fragmentTransaction.commit();

    }
}