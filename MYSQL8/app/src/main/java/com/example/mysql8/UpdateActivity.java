package com.example.mysql8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText name,id;
    TextView viewname,viewid;
    LinearLayout linearLayout,linearLayout1;
    Button edit,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name=findViewById(R.id.username);
        id=findViewById(R.id.id);

        viewname=findViewById(R.id.viewname);
        viewid=findViewById(R.id.viewid);

        update=findViewById(R.id.enter);
        edit=findViewById(R.id.edit);

        linearLayout=findViewById(R.id.linear);
        linearLayout1=findViewById(R.id.linear1);
        Intent intent=getIntent();

        int position=intent.getIntExtra("position",0);
        String name1=intent.getStringExtra("name");

        viewname.setText("Name : "+name1);
        viewid.setText("Id : "+intent.getIntExtra("ID",0));


        Toast.makeText(this, name1+""+position, Toast.LENGTH_SHORT).show();

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
            int id1=intent.getIntExtra("ID",0);

            Boolean value=dataBase.updateValue(id1,name1);

             if(value)
                {
                    Toast.makeText(UpdateActivity.this, "update value suusefull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(UpdateActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });



    }
}