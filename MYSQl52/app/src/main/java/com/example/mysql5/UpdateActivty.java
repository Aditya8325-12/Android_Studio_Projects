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

public class UpdateActivty extends AppCompatActivity {



    EditText name,email,password1;
    TextView viewname,viewemail,viewpassword;
    LinearLayout linearLayout,linearLayout1;
    Button edit,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activty);


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

        int position=intent.getIntExtra("position",0);

        DataBAse dataBAse=new DataBAse(this);

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

                boolean value=dataBAse.UpdateDataBase(position+1,name1,password,email1);

                if(value)
                {
                    Toast.makeText(UpdateActivty.this, "update value suusefull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(UpdateActivty.this,MainActivity.class);
                    startActivity(intent);
                }



            }
        });


    }
}