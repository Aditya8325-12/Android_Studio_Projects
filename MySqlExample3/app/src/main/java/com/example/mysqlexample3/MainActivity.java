package com.example.mysqlexample3;

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



    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter arrayAdapter;
    List<CreateAccount> createAccountslist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=findViewById(R.id.listview);

        DataBase dataBase=new DataBase(this);



        if(dataBase.getcount()==0)
        {
            dataBase.putValueInDataBase(new CreateAccount(1,18,"aurangabad"));
            dataBase.putValueInDataBase(new CreateAccount(2,18,"aurangabad"));
            dataBase.putValueInDataBase(new CreateAccount(3,18,"aurangabad"));
            dataBase.putValueInDataBase(new CreateAccount(4,18,"aurangabad"));
        }

        createAccountslist=dataBase.getAllElement();



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
            case R.id.addlist:
                Intent intent=new Intent(MainActivity.this,addlistactivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}