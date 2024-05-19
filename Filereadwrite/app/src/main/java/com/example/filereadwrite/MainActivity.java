package com.example.filereadwrite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nametextview;
    Button s,l;
    EditText nameedit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameedit=findViewById(R.id.nameedit);
        nametextview=findViewById(R.id.nametext);
        s=findViewById(R.id.save);
        l=findViewById(R.id.load);

        s.setOnClickListener(this);
        l.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.save:
                String text=nameedit.getText().toString();
                 try {
                     FileOutputStream fileo=openFileOutput("text.txt",MODE_PRIVATE);
                     File file=getFilesDir();
                     fileo.write(text.getBytes());
                     fileo.close();
                     Toast.makeText(getApplicationContext(), "save this file", Toast.LENGTH_SHORT).show();
                 }
                 catch (FileNotFoundException e)
                 {
                     e.printStackTrace();
                 }
                 catch (IOException e)
                 {
                     e.printStackTrace();
                 }
                 nameedit.setText("");
                 break;
            case R.id.load:
                String text2=nameedit.getText().toString();
                StringBuilder str=new StringBuilder();
                try {
                    FileInputStream filei= openFileInput("text.txt");
                    int r=0;
                    while ( (r = filei.read()) != -1)
                    {
                        str.append((char)r);
                        nametextview.setText("\n\n name ==   "+str.toString());
                    }
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }



        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setMessage("are you soure to exit the app ")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "exite the appp", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "sdfsdgsdf", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}