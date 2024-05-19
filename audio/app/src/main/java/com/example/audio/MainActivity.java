package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,stop;
    MediaPlayer medi;
    SeekBar seek=null;
    AudioManager audio=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stop=findViewById(R.id.stop);
        play=findViewById(R.id.play);
        medi= MediaPlayer.create(MainActivity.this,R.raw.adity);
        stop.setOnClickListener(this);
        play.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.play:
//                medi.start();
                showf(new Fragment2());

            case R.id.stop:
                showf(new Fragment1());
//                medi.stop();

        }
    }


    private void showf(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }


}