package com.example.mysql8;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public static List<Student> studentList=new ArrayList<>();
     ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter arrayAdapter;

    Student student;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

         dataBase=new DataBase(this);

         Showlistdata();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {



                Toast.makeText(MainActivity.this, "dsfg"+position, Toast.LENGTH_SHORT).show();

                student=dataBase.getStudent(studentList.get(position).id);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Do You Want To delete This data")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataBase.DeleteValue(student);
                                studentList.clear();
                                arrayList.clear();
                                Showlistdata();
                            }
                        }).setNegativeButton("no",null).show();

                return true;
            }
        });



    }


    public void Showlistdata()
    {
        studentList=dataBase.getAllStudent();

        if(studentList.size()!=0)
        {

            for(int i=0;i<studentList.size();i++)
            {
                arrayList.add(""+studentList.get(i).id+" , "+studentList.get(i).name);
            }

        }
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,UpdateActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("name",studentList.get(position).name);
                intent.putExtra("ID",studentList.get(position).id);
                startActivity(intent);
            }
        });


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
                Intent intent=new Intent(MainActivity.this,addActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}