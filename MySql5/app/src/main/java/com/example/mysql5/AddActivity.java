package com.example.mysql5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {


    EditText id,name,password,email;

    Button enter;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        password=findViewById(R.id.password);
        name=findViewById(R.id.username);
        email=findViewById(R.id.email);
        enter=findViewById(R.id.enter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Data");
        DataBase dataBase=new DataBase(this);

        count=dataBase.getLastCount();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int pass1=Integer.parseInt(password.getText().toString());
                String name1=name.getText().toString();
                String  email1=email.getText().toString();

                dataBase.putValueInDataBase(new Student(count+1,name1,pass1,email1));
                Intent intent=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}