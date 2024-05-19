package com.example.sharedpreferanse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createaccount extends AppCompatActivity {


    Button button;
    EditText user,phone;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        user=findViewById(R.id.user);
        phone=findViewById(R.id.phone);
        button=findViewById(R.id.create);


        sharedPreferences=getSharedPreferences("my-re",MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean userempty= TextUtils.isEmpty(user.getText().toString());
                Boolean phoneempty= TextUtils.isEmpty(phone.getText().toString());

                if(userempty==true && phoneempty==true)
                {
                    user.setError("Plese enter the value");
                    phone.setError("Plese enter the value");
                }
                else
                {
                    SharedPreferences.Editor edit=sharedPreferences.edit();
                    String UserValue=user.getText().toString();
                    String PhoneValue=phone.getText().toString();
                    edit.putString("user",UserValue);
                    edit.putString("phone",PhoneValue);
                    edit.commit();


                    Toast.makeText(createaccount.this, "account created", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(createaccount.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}