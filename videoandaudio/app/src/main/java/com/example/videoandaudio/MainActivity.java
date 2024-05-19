package com.example.videoandaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.security.Provider;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

//for video
    VideoView video;
    Button play;
    int postion=0;

//    for audio

    Button play1,pause,stop;
    MediaPlayer medi1;

    // seek bar

    SeekBar seek=null;
    AudioManager audio=null;



    MediaController medi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.play);
        video=findViewById(R.id.videoview);
        medi=new MediaController(this);
        medi.setAnchorView(video);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.setMediaController(medi);
                String  s="android.resource://"+getPackageName()+"/"+R.raw.vi3;
                Uri uri=Uri.parse(s);
                video.setVideoURI(uri);
                video.requestFocus();

            }
        });

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                video.seekTo(postion);
                if(postion==0)
                {
                    video.start();
                }
            }
        });




//         audio

        pause=findViewById(R.id.pause);
        play1=findViewById(R.id.play1);
        stop=findViewById(R.id.stop);

        medi1= MediaPlayer.create(MainActivity.this,R.raw.audio);
        pause.setOnClickListener(this);
        play1.setOnClickListener(this);
        stop.setOnClickListener(this);



            init();
    }

    public void init()
    {
       seek=findViewById(R.id.seekbar);
       audio=(AudioManager)getSystemService(AUDIO_SERVICE);
       seek.setMax(audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
       seek.setProgress(audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
       seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               audio.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
               Toast.makeText(MainActivity.this, Integer.toString(i)+"", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.pause:
                medi1.pause();
                break;
            case R.id.play1:
                medi1.start();
                break;
            case R.id.stop:
                medi1.stop();
        }
    }
}