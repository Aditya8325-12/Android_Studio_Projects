package com.example.mysql8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addActivity extends AppCompatActivity {


    EditText entername,enterid;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        entername=findViewById(R.id.entername);
        enterid=findViewById(R.id.enterid);

        enter=findViewById(R.id.enter);

        DataBase dataBase=new DataBase(this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checknam= TextUtils.isEmpty(entername.getText().toString());
                boolean checkid=TextUtils.isEmpty(enterid.getText().toString());

                if(checknam==true && checkid==true)
                {
                    entername.setError("Plese enter the value");
                    enterid.setError("plese Enter the value");
                }
                else
                {
                    dataBase.addStudent(new Student(Integer.parseInt(enterid.getText().toString()),entername.getText().toString()));
                     entername.setText("");
                    enterid.setText("");
                    Intent intent=new Intent(addActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}