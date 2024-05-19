package com.kazimasum.qrdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {

    Button scanbtn;
    public static TextView scantext,value,discountvalue;


    Button account;
    public  static EditText  packet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        account=findViewById(R.id.account);
        packet=findViewById(R.id.packet);


        scantext=(TextView)findViewById(R.id.scantext);
        value=findViewById(R.id.productvalue);
        discountvalue=findViewById(R.id.discountvalue);


        scanbtn=(Button) findViewById(R.id.scanbtn);

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),scannerView.class));
            }
        });




        Intent intent=getIntent();

        scantext.setText(""+intent.getStringExtra("name"));
        value.setText(""+intent.getIntExtra("value",1));
        discountvalue.setText(""+intent.getIntExtra("discout",1));



        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=getIntent();
                int packetvalue=intent.getIntExtra("packet",0);
                int scanvalue=intent.getIntExtra("scan",0);
                int totalamount=packetvalue*scanvalue;

                Toast.makeText(home.this, "Total amount =="+totalamount, Toast.LENGTH_SHORT).show();

            }
        });





    }
}