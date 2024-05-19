package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button l;
    EditText us,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l=findViewById(R.id.Login);
        us=findViewById(R.id.username);
        pas=findViewById(R.id.password);

        l.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Boolean cuser=TextUtils.isEmpty(us.getText().toString());
        Boolean cpass=TextUtils.isEmpty(pas.getText().toString());
        if(cuser ==true)
        {
            us.setError("plese enter the user name");
        }
        if(cpass==true){
            pas.setError("plese enter the password");
        }
        if(cuser == false && cpass==false)
        {
            int user=Integer.parseInt(us.getText().toString());
            int pass=Integer.parseInt(pas.getText().toString());
            if(user==1111 && pass==2222)
            {
                Toast.makeText(this, " save the files ", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,fistpage.class);
                startActivity(i);
            }
            else
            {
                us.setText("");
                pas.setText("");
                Toast.makeText(this, "Wrong user id and password", Toast.LENGTH_SHORT).show();
            }

        }
    }
}