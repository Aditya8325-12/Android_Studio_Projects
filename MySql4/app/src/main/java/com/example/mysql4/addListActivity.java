package com.example.mysql4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addListActivity extends AppCompatActivity {


EditText id,password,name,email;

Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        id=findViewById(R.id.ID);
        password=findViewById(R.id.password);
        name=findViewById(R.id.username);
        email=findViewById(R.id.email);
        enter=findViewById(R.id.enter);

        DataBase dataBase=new DataBase(this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checkUser= TextUtils.isEmpty(name.getText().toString());
                boolean checkid= TextUtils.isEmpty(id.getText().toString());
                boolean checkpass= TextUtils.isEmpty(password.getText().toString());
                boolean checkemail= TextUtils.isEmpty(email.getText().toString());

                    int id1=Integer.parseInt(id.getText().toString());
                    int pass1=Integer.parseInt(password.getText().toString());
                    String name1=name.getText().toString();
                    String  email1=email.getText().toString();

                    dataBase.putValueInDataBase(new CreateUser(id1,pass1,name1,email1));
                    Intent intent=new Intent(addListActivity.this,MainActivity.class);
                    startActivity(intent);



            }
        });
    }
}