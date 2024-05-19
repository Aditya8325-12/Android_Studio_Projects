package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button play;

    MediaController medi;
    int postion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=findViewById(R.id.videoview);
        play=findViewById(R.id.play);
        medi=new MediaController(this);
        medi.setAnchorView(videoView);



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path="android.resource://"+getPackageName()+"/"+R.raw.vi2;
                videoView.setMediaController(medi);
                Uri uri= Uri.parse(path);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
            }
        });



        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(postion);
                if(postion==0)
                {
                    videoView.start();
                }
            }
        });
    }
}