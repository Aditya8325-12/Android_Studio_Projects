package com.example.mysql4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    List<CreateUser> createUserList=new ArrayList<>();
    TextView name,id,password,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);


        DataBase dataBase=new DataBase(this);

        Intent intent=getIntent();

        String  name1=intent.getStringExtra("name");
        int  id1=intent.getIntExtra("id",0);
        int  password1=intent.getIntExtra("password",0);
        String  email1=intent.getStringExtra("email");

        name.setText("Name : "+name1);
        id.setText("Id : "+id1);
        password.setText("Password : "+password1);
//        email.setText("Email : "+email1);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("User Details ");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch(item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }
}