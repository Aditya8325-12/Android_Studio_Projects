package com.example.sqlddatabaseexample1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addlistactivity extends AppCompatActivity {

    EditText userid,password,email,username;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlistactivity);

        userid=findViewById(R.id.ID);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        button=findViewById(R.id.enter);
        username=findViewById(R.id.ID);


        dataBase database=new dataBase(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkuser= TextUtils.isEmpty(userid.getText().toString());
                boolean checkpass= TextUtils.isEmpty(email.getText().toString());
                boolean checkemail= TextUtils.isEmpty(password.getText().toString());

                if(checkuser=true && checkpass==true && checkemail==true)
                {
                    username.setError("please enter the username");
                    password.setError("please enter the password");
                    email.setError("please enter the email");
                }
                else
                {
                    int userid=Integer.parseInt(username.getText().toString());
                    int passid=Integer.parseInt(password.getText().toString());
                    String emailid=email.getText().toString();
                    database.putValueInDataBase(new Studentclass(userid,username.getText().toString(),passid,emailid));
                    Intent intent=new Intent(addlistactivity.this,MainActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}