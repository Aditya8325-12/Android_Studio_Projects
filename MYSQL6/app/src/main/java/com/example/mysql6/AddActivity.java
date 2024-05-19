package com.example.mysql6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {


    EditText EnterId,EnterName;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EnterId=findViewById(R.id.enterid);
        EnterName=findViewById(R.id.entername);
        enter=findViewById(R.id.enter);

        DataBase dataBase=new DataBase(this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checknam= TextUtils.isEmpty(EnterName.getText().toString());
                boolean checkid=TextUtils.isEmpty(EnterId.getText().toString());

                if(checknam==true && checkid==true)
                {
                    EnterId.setError("Plese enter the value");
                    EnterName.setError("plese Enter the value");
                }
                else
                {
                    dataBase.putValueInDataBase(new Student(Integer.parseInt(EnterId.getText().toString()),EnterName.getText().toString()));
                    EnterId.setText("");
                    EnterName.setText("");

                    Intent intent=new Intent(AddActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });



    }
}