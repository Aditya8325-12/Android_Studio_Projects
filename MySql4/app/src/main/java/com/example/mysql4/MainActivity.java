package com.example.mysql4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> allList=new ArrayList<>();
    List<CreateUser> createUserList=new ArrayList<>();
    ArrayAdapter arrayAdapter;
    private  DataBase dataBase;
    private int  count=0;
    private CreateUser createUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.Listview);

        DataBase dataBase=new DataBase(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.additem:
                Intent intent=new Intent(MainActivity.this,addListActivity.class);
                startActivity(intent);
                break;
            case R.id.DeleteAllList:

                break;
        }
        return super.onOptionsItemSelected(item);
    }



}