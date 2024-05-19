package com.example.listjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Addlistview extends AppCompatActivity {

    EditText name,username,phone,email;

    Button addList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlistview);
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);

        addList=findViewById(R.id.addlist);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.getText().toString()==null || username.getText().toString()==null ||  phone.getText().toString()==null ||  email.getText().toString()==null )
                {
                    name.setError("Please Fill The value");
                    username.setError("Please Fill The value");
                    phone.setError("Please Fill The value");
                    email.setError("Please Fill The value");
                }

                String nameedit=name.getText().toString();
                String usernameedit=username.getText().toString();
                String phoneedit=phone.getText().toString();
                String emailedit=email.getText().toString();
                Intent intent=new Intent(Addlistview.this,MainActivity.class);
                intent.putExtra("name",nameedit);
                intent.putExtra("username",usernameedit);
                intent.putExtra("phone",phoneedit);
                intent.putExtra("email",emailedit);
                startActivity(intent);
            }
        });


    }
}