package com.example.gate_exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class login_page extends AppCompatActivity {

    EditText user_name,password;
    Button login;
    TextView register;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user_name=findViewById(R.id.user);
        password=findViewById(R.id.pass);
        login=findViewById(R.id.Login);
        register=findViewById(R.id.sign);
        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);

//        dont have account go to the register page
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_page.this,user_registration.class));
            }
        });
//       login section
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_name.getText().toString().equals("") && password.getText().toString().equals(""))
                {
                    user_name.setError("please Fill");
                    password.setError("please Fill");
                }
                else{
                    String user=user_name.getText().toString();
                    String pass=password.getText().toString();
                    String query="?t1=login&t2="+user+"&t3="+pass;
                    get_data_from_url obj=new get_data_from_url();
                    obj.execute(getString(R.string.path)+query);
                }
            }
        });
    }

//    get data from url
    class  get_data_from_url extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                return  bufferedReader.readLine();
            } catch (Exception e) {
                return    e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("Found"))
            {
                SharedPreferences.Editor edit=sharedPreferences.edit();
                String username=user_name.getText().toString();
                String pass=password.getText().toString();
                edit.putString("user",username);
                edit.putString("pass",pass);
                edit.commit();
                startActivity(new Intent(login_page.this,Home_page.class));
                user_name.setText("");
                password.setText("");
            }
            else
            {
                Toast.makeText(login_page.this, "user not found ", Toast.LENGTH_SHORT).show();
            }
        }
    }


}