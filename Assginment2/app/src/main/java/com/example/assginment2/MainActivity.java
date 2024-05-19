package com.example.assginment2;

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


    Button save,retrive,cler;
    EditText u,p,a;
    TextView tu,tn,td;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.save);
        retrive=findViewById(R.id.retrive);
        cler=findViewById(R.id.clear);
        u=findViewById(R.id.user);
        p=findViewById(R.id.phone);
        a=findViewById(R.id.address);


        tu=findViewById(R.id.textname);
        tn=findViewById(R.id.textnumber);
        td=findViewById(R.id.);

        sp=getSharedPreferences("mypre",MODE_PRIVATE);

        save.setOnClickListener(this);
        retrive.setOnClickListener(this);
        cler.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.save:
                boolean checkuser= TextUtils.isEmpty(user.getText().toString());
                boolean checkphone= TextUtils.isEmpty(phone.getText().toString());
                boolean checaddress= TextUtils.isEmpty(address.getText().toString());
                if(checkuser ==true)
                {
                    user.setError("Enter the name");
                }
                else
                {
                    user.setText("");
                }
                if(checkphone ==true)
                {
                    phone.setError("Enter the Phone number");
                }
                else
                {
                    phone.setText("");
                }
                if(checaddress ==true)
                {
                    address.setError("Enter the address");
                }
                else
                {
                    address.setText("");
                }

                if(checaddress== false && checkuser==false && checkphone==false)
                {
                    SharedPreferences.Editor edit=sp.edit();
                    edit.putString("user",user.getText().toString());
                    edit.putString("phone",phone.getText().toString());
                    edit.putString("address",address.getText().toString());
                    edit.commit();
                    Toast.makeText(this, "save sussefully", Toast.LENGTH_SHORT).show();
                    user.setText("");
                    phone.setText("");
                    address.setText("");
                }

                break;
            case R.id.retrive:

                if(sp.contains("phone"))
                {
                    String ph=sp.getString("phone","");
                    number.setText("phone=="+ph);
                }
                else
                {
                    number.setText("");
                }
                if(sp.contains("address"))
                {
                    String ad=sp.getString("address","");
                    add.setText("Address=="+ad);
                }
                else
                {
                    add.setText("");
                }
                break;

        }
    }
}