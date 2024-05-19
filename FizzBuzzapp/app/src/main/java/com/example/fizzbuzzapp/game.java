package com.example.fizzbuzzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game extends AppCompatActivity implements View.OnClickListener {
    TextView Random;
    Button fizz,buzz,fizzbuzz,next;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Random=findViewById(R.id.randomnumber);
        fizz=findViewById(R.id.fizz);
        buzz=findViewById(R.id.buzz);
        fizzbuzz=findViewById(R.id.fizzbuzz);
        next=findViewById(R.id.next);
        fizz.setOnClickListener(this);
        buzz.setOnClickListener(this);
        fizzbuzz.setOnClickListener(this);
        next.setOnClickListener(this);
        genraaterandom();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.fizz:
                num=Integer.parseInt(Random.getText().toString());
                if(num%3== 0)
                {
                genraaterandom();
                }
                else
                {
                    alert();
                }
                break;
            case R.id.buzz:
                num=Integer.parseInt(Random.getText().toString());
                if(num%5== 0)
                {
                    genraaterandom();
                }
                else
                {
                    alert();
                }
                break;
            case R.id.fizzbuzz:
                num=Integer.parseInt(Random.getText().toString());
                if(num%3== 0 && num%5==0)
                {
                    genraaterandom();
                }
                else
                {
                    alert();
                }
                break;
            case R.id.next:
                    genraaterandom();
                break;
        }
    }
    public void genraaterandom()
    {
        int num=(int) Math.floor((Math.random()*100)+1);
        Random.setText(""+num);
    }
    public  void alert()
    {
        new AlertDialog.Builder(game.this)
                .setTitle("Game Over")
                .setMessage("are you Restart the game")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        genraaterandom();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent j=new Intent(game.this,MainActivity.class);
                        startActivity(j);
                        dialogInterface.cancel();
                    }
                }).show();
    }



    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        new AlertDialog.Builder(this)
        .setMessage("Are you showr to exit the game")
        .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent j=new Intent(game.this,MainActivity.class);
                        j.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(j);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }


}