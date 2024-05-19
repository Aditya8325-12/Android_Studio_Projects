package com.example.mysqlexample2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class addlistactivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter arrayAdapter;
    List<CreateAccount> createAccountslist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlistactivity);

        listView=findViewById(R.id.listview);

        DataBase dataBase=new DataBase(this);


        createAccountslist=dataBase.getAllElement();
//
//        if (dataBase.getcount() == 0)
//        {
//            Intent intent=new Intent(addlistactivity.this,MainActivity.class);
//            startActivity(intent);
//        }


        if(createAccountslist.size()!=0 ){

                for(int i=0;i<=createAccountslist.size();i++)
                {
                    arrayList.add(""+createAccountslist.get(i).UName+","+createAccountslist.get(i).Email);

                }
        }

        arrayAdapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
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
            case R.id.additem:
                Intent intent=new Intent(addlistactivity.this,MainActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}