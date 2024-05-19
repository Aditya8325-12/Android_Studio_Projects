package com.example.mysql5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UpdataActivyt extends AppCompatActivity {

    EditText name,email,password1;

    TextView viewname,viewemail,viewpassword;


    LinearLayout linearLayout,linearLayout1;
    Button edit,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_activyt);
        name=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password1=findViewById(R.id.password);

        viewemail=findViewById(R.id.viewemail);
        viewname=findViewById(R.id.viewname);
        viewpassword=findViewById(R.id.viewpassword);

        update=findViewById(R.id.enter);
        edit=findViewById(R.id.edit);

        linearLayout=findViewById(R.id.linear);
        linearLayout1=findViewById(R.id.linear1);
        Intent intent=getIntent();


        viewname.setText("Name : "+intent.getStringExtra("name"));
        viewemail.setText("Email :"+ intent.getStringExtra("email"));
        viewpassword.setText("Password :"+intent.getIntExtra("password",0));


        DataBase dataBase=new DataBase(this);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout1.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name1=name.getText().toString();
                String email1=email.getText().toString();
                int password=Integer.parseInt(password1.getText().toString());
                int position=intent.getIntExtra("position",0);


                boolean value=dataBase.updateTheTable(position+2,name1,password,email1);



                if(value)
                {
                    Toast.makeText(UpdataActivyt.this, "update value suusefull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(UpdataActivyt.this,MainActivity.class);
                    startActivity(intent);
                    }



            }
        });




    }
}