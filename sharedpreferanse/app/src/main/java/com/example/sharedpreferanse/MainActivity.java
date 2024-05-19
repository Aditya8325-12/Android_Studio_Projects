package com.example.sharedpreferanse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button save,retrive,clear;
    EditText user,phone;
    TextView usertext,passtext;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.save);
        retrive=findViewById(R.id.retrive);
        clear=findViewById(R.id.clear);
        user=findViewById(R.id.user);
        phone=findViewById(R.id.phone);
        usertext=findViewById(R.id.usertext);
        passtext=findViewById(R.id.passtext);

        save.setOnClickListener(this);
        retrive.setOnClickListener(this);
        clear.setOnClickListener(this);


         sp=getSharedPreferences("mypre",MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.save:
                boolean checkuser= TextUtils.isEmpty(user.getText().toString());
                boolean checkphone= TextUtils.isEmpty(phone.getText().toString());
                if(checkuser == true)
                {
                    user.setError("plese eneter the user name");
                }
                if(checkphone == true)
                {
                    phone.setError("plese enter the phone name");
                }
                if(checkphone==false && checkuser==false)
                {
                    SharedPreferences.Editor edit=sp.edit();
                    edit.putString("user",user.getText().toString());
                    edit.putString("phone",phone.getText().toString());
                    edit.commit();
                    Toast.makeText(this, "save the data sussefully", Toast.LENGTH_SHORT).show();
                    user.setText("");
                    phone.setText("");
                }
                break;
            case R.id.retrive:
                    if(sp.contains("user"))
                    {
                        String name=sp.getString("user","");
                        usertext.setText("name =="+name);
                    }
                    else
                    {
                        usertext.setText("");
                    }
                    if(sp.contains("phone"))
                    {
                        String name=sp.getString("phone","");
                        passtext.setText("phone =="+name);
                    }
                    else
                    {
                        passtext.setText("");
                    }
                break;
            case R.id.clear:
                SharedPreferences.Editor edit=sp.edit();
                edit.clear();
                edit.commit();
                break;
        }
    }
}