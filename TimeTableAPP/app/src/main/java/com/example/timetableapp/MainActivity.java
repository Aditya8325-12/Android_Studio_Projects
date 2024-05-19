package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.linear);

        ArrayList<String> listViews=new ArrayList<>();
        listViews.add("Monday");
        listViews.add("Tuesday");
        listViews.add("Wednesday");
        listViews.add("Thursday");
        listViews.add("Friday");
        listViews.add("Saturday");
        listViews.add("Sunday");


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listViews);
        listView.setAdapter(arrayAdapter);


        sharedPreferences=getSharedPreferences("My-pre",MODE_PRIVATE);
        SharedPreferences.Editor edit=sharedPreferences.edit();

        if(!sharedPreferences.contains("days"))
        {
            edit.putBoolean("days",true);

            edit.putString("Monday","English 10:30");
            edit.putString("Tuesday","Marathi 10:30");
            edit.putString("Wednesday","Hindi 10:30");
            edit.putString("Thursday","Science 10:30");
            edit.putString("Friday","Engineering 10:30");
            edit.putString("Saturday","History 10:30");
            edit.putString("Sunday","Math 10:30");

            edit.commit();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int Positions, long l) {
                Intent intent=new Intent(MainActivity.this,textviews.class);
                intent.putExtra("positions",listViews.get(Positions));
                startActivity(intent);
            }
        });

    }
}