package com.example.mysql5;

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
     public  static List<Student> students=new ArrayList<>();
     public  static ArrayList<String> studentsList=new ArrayList<>();
     public  static ArrayAdapter arrayAdapter;

     DataBAse dataBAse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

         dataBAse=new DataBAse(this);

        ShowListItem();


    }



    public  void  ShowListItem()
    {
        students=dataBAse.getAllStudent();

        if(students.size()!=0)
        {
            for(int  i=0;i<students.size();i++)
            {
                studentsList.add(""+students.get(i).name+","+students.get(i).id);
            }
        }
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,studentsList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,UpdateActivty.class);
                intent.putExtra("position",position);
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
                Intent intent=new Intent(MainActivity.this,AddActivty.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}