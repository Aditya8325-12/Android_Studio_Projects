package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fistpage extends AppCompatActivity implements View.OnClickListener {

    Button insert,view,find,book,all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fistpage);
        insert=findViewById(R.id.insert);
        view=findViewById(R.id.view);
        find=findViewById(R.id.Find);
        book=findViewById(R.id.book);
        all=findViewById(R.id.all);

        insert.setOnClickListener(this);
        view.setOnClickListener(this);
        find.setOnClickListener(this);
        book.setOnClickListener(this);
        all.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.insert:
                Intent i=new Intent(fistpage.this,insert.class);
                startActivity(i);
                break;
            case R.id.view:
                Intent j=new Intent(fistpage.this,allmovie.class);
                startActivity(j);
                break;
            case R.id.Find:
                Intent k=new Intent(fistpage.this,findmovie.class);
                startActivity(k);
                break;
            case R.id.book:
                Intent l=new Intent(fistpage.this,book.class);
                startActivity(l);
                break;
            case R.id.all:
                Intent m=new Intent(fistpage.this,transation.class);
                startActivity(m);
                break;
        }
    }
}