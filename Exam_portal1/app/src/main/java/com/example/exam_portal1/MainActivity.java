package com.example.exam_portal1;

import androidx.annotation.NonNull;
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
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    TextView sign;
    Button login;
    EditText user,pass;
    String path="https://gprep.000webhostapp.com/android_process.php";
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign=findViewById(R.id.sign);
        login=findViewById(R.id.Login);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("") && pass.getText().toString().equals(""))
                {
                    user.setError("plese fill the value");
                    pass.setError("plese fill the value");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "value has been procced", Toast.LENGTH_SHORT).show();

                    String username=user.getText().toString();
                    String password=pass.getText().toString();

                    String query="?t1=Login"+"&t2="+username+"&t3="+password;

                    class  process extends AsyncTask<String,Void,String>
                    {

                        @Override
                        protected String doInBackground(String... strings) {

                            try {

                                URL url=new URL(strings[0]);
                                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                return  bufferedReader.readLine();
                            }
                            catch (Exception ex)
                            {
                               return ex.getMessage();
                            }
                        }



                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);

                            if(s.equals("Found"))
                            {
                                user.setText("");
                                pass.setText("");
                                Toast.makeText(MainActivity.this, "Login sussesfull"+s, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,home.class));
                            }
                            else
                            {
                                user.setText("");
                                pass.setText("");
                                Toast.makeText(MainActivity.this, "user not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    process obj=new process();
                    obj.execute(path+query);
                }
            }
        });



        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,sign.class));
            }
        });

    }
}