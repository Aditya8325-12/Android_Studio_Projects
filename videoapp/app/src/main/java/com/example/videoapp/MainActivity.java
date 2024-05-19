package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button b1;
    VideoView VideoView;
    MediaController medi;
   int  positon=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.play);
        VideoView=findViewById(R.id.videview);
        medi=new MediaController(MainActivity.this);
        medi.setAnchorView(VideoView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mpath="android:resource//"+getPackageName()+"/"+R.raw.nature;
                Uri uri= Uri.parse(mpath);
                VideoView.setVideoURI(uri);
                VideoView.requestFocus();
                    VideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            VideoView.seekTo(positon);
                            if(positon==0)
                            {
                                VideoView.start();
                            }
                        }
                    });
                }
        });

    }
}