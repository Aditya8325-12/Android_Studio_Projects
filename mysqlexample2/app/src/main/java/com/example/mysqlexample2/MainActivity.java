package com.example.mysqlexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText username,password,email;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        button=findViewById(R.id.enter);

        DataBase dataBase=new DataBase(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkuser= TextUtils.isEmpty(username.getText().toString());
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
                    dataBase.putValueInDataBase(new CreateAccount(userid,passid,emailid));
                    Intent intent=new Intent(MainActivity.this,addlistactivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}