package com.example.gate_exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class user_registration extends AppCompatActivity {


    EditText user,pass,f_name,college_id;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);


        user=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        f_name=findViewById(R.id.Fname);
        college_id=findViewById(R.id.college_id);
        register=findViewById(R.id.sign);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals("") && pass.getText().toString().equals("") &&  f_name.getText().toString().equals("") && college_id.getText().toString().equals("") )
                {
                    user.setError("please fill");
                    pass.setError("please fill");
                    f_name.setError("please fill");
                    college_id.setError("please fill");
                }
                else
                {
                    Toast.makeText(user_registration.this, "clikc s", Toast.LENGTH_SHORT).show();
                    String user_name=user.getText().toString();
                    String password=pass.getText().toString();
                    String Full_name=f_name.getText().toString();
                    String Collage_id=college_id.getText().toString();
                    String query="?t1=signup&t2="+user_name+"&t3="+password+"&t4="+Full_name+"&t5="+Collage_id;
                    send_data_to_url obj=new send_data_to_url();
                    obj.execute(getString(R.string.path)+query);
                }
            }
        });
    }

//send data to the url
    class send_data_to_url extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                return  bufferedReader.readLine();
            }catch (Exception e)
            {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            user.setText("");
            pass.setText("");
            f_name.setText("");
            college_id.setText("");
            Intent intent=new Intent(user_registration.this,login_page.class);
            startActivity(intent);
            Toast.makeText(user_registration.this, "Register Sucsefull"+s, Toast.LENGTH_SHORT).show();
        }
    }


}