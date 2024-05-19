package com.example.sharedpreferanse2;

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
    EditText euser,ephone,eaddress;
    TextView tuser,tphone,taddress;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.Buttonsave);
        retrive=findViewById(R.id.Buttonretrive);
        clear=findViewById(R.id.Buttonclear);

        euser=findViewById(R.id.Edituser);
        ephone=findViewById(R.id.Editphone);
        eaddress=findViewById(R.id.Editaddress);

        tuser=findViewById(R.id.textuser);
        tphone=findViewById(R.id.textphone);
        taddress=findViewById(R.id.textaddress);

        sp=getSharedPreferences("mypref",MODE_PRIVATE);

        save.setOnClickListener(this);
        retrive.setOnClickListener(this);
        clear.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Buttonsave:
                boolean checkuser= TextUtils.isEmpty(euser.getText().toString());
                boolean checkphone= TextUtils.isEmpty(ephone.getText().toString());
                boolean checkaddress= TextUtils.isEmpty(eaddress.getText().toString());
                if(checkuser ==true)
                {
                    euser.setError("plese fill");
                }
                if(checkphone ==true)
                {
                    ephone.setError("plese fill");
                }
                if(checkaddress ==true)
                {
                    eaddress.setError("plese fill");
                }
                if(checkphone ==false && checkuser==false)
                {
                    SharedPreferences.Editor edit=sp.edit();
                    edit.putString("user",euser.getText().toString());
                    edit.putString("phone",ephone.getText().toString());
                    edit.putString("address",eaddress.getText().toString());
                    euser.setText("");
                    ephone.setText("");
                    eaddress.setText("");
                    edit.commit();
                    Toast.makeText(this, "savesussfully", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Buttonretrive:
                if(sp.contains("user"))
                {
                    String spuser=sp.getString("user","");
                    tuser.setText("name =="+spuser);
                }
                else
                {
                    tuser.setText("");
                }
                if(sp.contains("phone"))
                {
                    String spphone=sp.getString("phone","");
                    tphone.setText("phone =="+spphone);
                }
                else
                {
                    tphone.setText("");
                }
                if(sp.contains("address"))
                {
                    String spaddress=sp.getString("address","");
                    taddress.setText("Address =="+spaddress);
                }
                else
                {
                    taddress.setText("");
                }
                break;
            case R.id.Buttonclear:
                SharedPreferences.Editor edit=sp.edit();
                edit.clear();
                edit.commit();
                tuser.setText("");
                tphone.setText("");
                taddress.setText("");
                break;


        }
    }
}