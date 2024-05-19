package com.example.notesaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public  static ArrayList<String> arrayList=new ArrayList<>();
    public  static ArrayAdapter arrayAdapter;
    ListView listView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        arrayList.add("Create Notes ");

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,WriteClass.class);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("note",position);
                editor.commit();
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("do you want to delete the list ")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(position);
                            }
                        })
                        .setNegativeButton("no",null).show();

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.appmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId()==R.id.addlist)
        {
            SharedPreferences sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("note",-1);
            editor.commit();
            Intent intent=new Intent(MainActivity.this,WriteClass.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }



    @Override
    protected void onResume() {
        super.onResume();

        String notelistdat=arrayList.get(arrayList.size()-1);
        if(notelistdat=="")
        {
            arrayList.remove(arrayList.size()-1);
            arrayAdapter.notifyDataSetChanged();
        }

    }
}