package com.example.mysql5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivty extends AppCompatActivity {



    EditText id,name,password,email;
    Button enter;

    int count=0;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activty);

        password=findViewById(R.id.password);
        name=findViewById(R.id.username);
        email=findViewById(R.id.email);
        id=findViewById(R.id.ID);
        enter=findViewById(R.id.enter);

        DataBAse dataBAse=new DataBAse(this);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id1=Integer.parseInt(id.getText().toString());
                 String name1=name.getText().toString();
                 String email1=email.getText().toString();
                 int password1=Integer.parseInt(password.getText().toString());

                dataBAse.PutValueInDataBase(new Student(id1,name1,password1,email1));

                Intent intent=new Intent(AddActivty.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}