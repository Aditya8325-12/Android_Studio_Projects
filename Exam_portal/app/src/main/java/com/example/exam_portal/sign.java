package com.example.exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class sign extends AppCompatActivity {



    EditText user,pass1;

    Button signin;
   public  static  final  String url="http://192.168.224.37/Exam_portal/android_process.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        signin=findViewById(R.id.sign);
        user=findViewById(R.id.username);
        pass1=findViewById(R.id.pass);



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String username=user.getText().toString();
                    String pass=pass1.getText().toString();
                    String query="?t1=signup"+"&t2="+username+"&t3="+pass;
                    bprocess obj=new bprocess();
                    obj.execute(url+query);
            }
        });

    }

    class bprocess  extends AsyncTask<String,Void,String>
    {



        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url1=new URL(strings[0]);
                HttpURLConnection conn=(HttpURLConnection)url1.openConnection();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                return  bufferedReader.readLine();

            }catch (Exception ex)
            {
                return  ex.getMessage();
            }
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(s.equals("sign_up_done")) {

                Toast.makeText(sign.this, "massage"+s, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(sign.this,Login.class));
            }
            else
            {
                user.setText("");
                pass1.setText("");
                Toast.makeText(sign.this, "massage"+s, Toast.LENGTH_SHORT).show();
            }

        }
    }




}