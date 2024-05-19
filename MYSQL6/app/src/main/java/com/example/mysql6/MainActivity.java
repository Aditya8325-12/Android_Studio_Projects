package com.example.mysql6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText EnterId,EnterName;
    Button enter;
    ListView listView;

    Student student;


    List<Student> studentsList=new ArrayList<>();
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter arrayAdapter;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=findViewById(R.id.listview);
        EnterId=findViewById(R.id.enterid);
        EnterName=findViewById(R.id.entername);
        enter=findViewById(R.id.enter);


        DataBase dataBase=new DataBase(this);


        studentsList=dataBase.GetValueFromDataBase();
        if(studentsList.size()!=0)
        {
            for(int i=0;i<studentsList.size();i++)
            {
                arrayList.add(""+studentsList.get(i).name+","+studentsList.get(i).id);
            }
        }
        else
        {
            Toast.makeText(this, "sndkfbkasndfksn", Toast.LENGTH_SHORT).show();
        }

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

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
            case R.id.addactivty:
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}