package com.example.mysqltoandroidstudii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    EditText name,username,password;
    Button enter;
    TextView login;

    String url="http://192.168.48.37/test/enterthevalueindatabase.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        login=findViewById(R.id.login);
        enter=findViewById(R.id.enter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String username1=username.getText().toString();
                String password1=password.getText().toString();

                String query="?t1="+0+"&t2="+name1+"&t3="+username1+"&t4="+password1;


                class  backgroundthread extends AsyncTask<String,Void,String>
                {

                    @Override
                    protected String doInBackground(String... strings) {
                        try {
                            URL url=new URL(strings[0]);
                            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            return  bufferedReader.readLine();
                        }
                        catch (Exception ec)
                        {
                            return ec.getMessage();
                        }

                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);

                        name.setText("");
                        password.setText("");
                        username.setText("");
                        Toast.makeText(MainActivity.this, "s"+s, Toast.LENGTH_SHORT).show();
                    }
                }

                backgroundthread ba=new backgroundthread();
                ba.execute(url+query);


            }
        });
    }
}