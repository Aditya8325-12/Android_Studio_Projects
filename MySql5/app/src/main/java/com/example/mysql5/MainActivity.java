package com.example.mysql5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
     private List<Student> students=new ArrayList<>();
    private ArrayList<String> arrayList=new ArrayList<>();
   private ArrayAdapter arrayAdapter;

   Student student;
    private DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        dataBase = new DataBase(this);
        showlistdata();


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
            case R.id.addItem:
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public  void  showlistdata()
    {


        students.clear();
        arrayList.clear();
        students=dataBase.getValueFromdataBase();
        if(students.size()!=0)
        {
            for(int i=0;i<students.size();i++)
            {
                arrayList.add(students.get(i).name+","+students.get(i).id);
            }
        }

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,UpdataActivyt.class);
                String name= students.get(position).name;
                String email= students.get(position).email;
                int password= students.get(position).password;
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });



    }


}