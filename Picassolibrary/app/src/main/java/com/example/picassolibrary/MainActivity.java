package com.example.picassolibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Picasso.get()
                .load("https://media.istockphoto.com/id/1280385511/photo/colorful-background.jpg?s=612x612&w=is&k=20&c=HHSfjsZOsQR8DwyxDh9bx5eXtQL193VupaGHo7m3Y9o=")
                .into(imageView);


    }
}