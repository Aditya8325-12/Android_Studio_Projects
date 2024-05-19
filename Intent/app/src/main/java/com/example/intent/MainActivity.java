package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etext1,etext2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext1=findViewById(R.id.text1);
        etext2=findViewById(R.id.text2);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean user= TextUtils.isEmpty(etext1.getText().toString());
                boolean pass= TextUtils.isEmpty(etext2.getText().toString());

                int u=Integer.parseInt(etext1.getText().toString());
                int p=Integer.parseInt(etext2.getText().toString());
                String pa=etext2.getText().toString();

                if(user==false && pass==false)
                {
                    if(u==1111 && p==2222){

                        Intent inte=new Intent(MainActivity.this,Target.class);
                        inte.putExtra("result",String.valueOf(pa));
                        startActivity(inte);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong user name and password", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "FIll the user name and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}