package com.example.audiotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button p,s;
    MediaPlayer medi;
    boolean value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=findViewById(R.id.play);
        s=findViewById(R.id.stoop);
        medi= MediaPlayer.create(MainActivity.this,R.raw.adity);
        p.setOnClickListener(this);
        s.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.play:
                showf(new Fragment1());
                    medi.start();
                break;
            case R.id.stoop:
                showf(new Fragment2());
                medi.stop();
                medi= MediaPlayer.create(MainActivity.this,R.raw.adity);
                break;
        }


    }


    private void showf(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }

}