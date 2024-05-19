package com.example.listjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SecoundPage extends AppCompatActivity {

    TextView name,username,email,phone;
    String url="https://jsonplaceholder.typicode.com/users/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound_page);

        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);

        Intent intent=getIntent();
        String s=intent.getStringExtra("value");
        int i=Integer.parseInt(s);
            i++;



        String newUrl=url+""+i;

        async as=new async();
        as.execute(newUrl);


    }


    public  class async extends AsyncTask<String,String,String>
    {

        URL url=null;
        HttpURLConnection httpURLConnection=null;
        @Override
        protected String doInBackground(String... strings) {

            try {
                url=new URL(strings[0]);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStream inputStream1=new BufferedInputStream(inputStream);

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream1));
                int i=bufferedReader.read();
                StringBuilder stringBuilder=new StringBuilder();
                while (i!=-1)
                {
                    stringBuilder.append((char) i);
                    i=bufferedReader.read();
                }


                String convertedString=stringBuilder.toString();


                return convertedString;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject jsonObject= null;
            try {
                jsonObject = new JSONObject(s);
                String name1=(String) jsonObject.getString("name");
                String username1=jsonObject.getString("username");
                String email1=jsonObject.getString("email");
                String phone1=jsonObject.getString("phone");
                name.setText("Name :"+name1);
                username.setText("Username :"+username1);
                phone.setText("Phone :"+phone1);
                email.setText("Email :"+email1);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}