package com.example.createtimetable2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.ListViews);

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Monday");
        arrayList.add("Tuesday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        arrayList.add("Saturday");
        arrayList.add("Sunday");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


        sharedPreferences=getSharedPreferences("My-pre",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        if(!sharedPreferences.contains("days"))
        {
            editor.putBoolean("days",true);
            editor.putString("Monday","Eng 6:30");
            editor.putString("Tuesday","Eng 6:30");
            editor.putString("Wednesday","Eng 6:30");
            editor.putString("Thursday","Eng 6:30");
            editor.putString("Friday","Eng 6:30");
            editor.putString("Saturday","Eng 6:30");
            editor.putString("Sunday","Eng 6:30");
            editor.commit();
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(MainActivity.this,Timetable.class);
                intent.putExtra("position",arrayList.get(position));
                startActivity(intent);
            }
        });
    }
}