package com.example.sqlddatabaseexample1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    List<Studentclass> arrayList=new ArrayList<>();
    ArrayList<String> studentlist=new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);


            dataBase dataBase=new dataBase(this);



            arrayList=dataBase.getAllStudents();
                if(arrayList.size()!=0)
                {
                    for(int i=0;i<arrayList.size();i++)
                    {
                        studentlist.add(""+arrayList.get(i).id+" "+arrayList.get(i).name+""+arrayList.get(i).age+""+arrayList.get(i).city);

                    }
                }

                else{
                    Toast.makeText(this, "sdkjfksdnfk", Toast.LENGTH_SHORT).show();
                }
            arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,studentlist);
            listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.additem:
                Intent intent=new Intent(MainActivity.this,addlistactivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}