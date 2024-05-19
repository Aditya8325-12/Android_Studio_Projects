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

import org.json.JSONArray;
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
import java.util.ArrayList;

public class Login extends AppCompatActivity {



    ArrayList<setvalueinarrray> arrayList= new ArrayList<>();

    EditText username,password;
    Button login;
    TextView register;
    String url="http://192.168.48.37/test/fatchdatabase.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.Login);
        register=findViewById(R.id.Registe);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fatchdata();
                String user=username.getText().toString();
                String pass=password.getText().toString();


                Toast.makeText(Login.this, "asdas"+arrayList.size(), Toast.LENGTH_SHORT).show();
                for(int i=0;i<=arrayList.size();i++)
                {
                    if(user.equals(arrayList.get(i).getUsername()) && password.equals(arrayList.get(i).getPassword()))
                    {
                        Toast.makeText(Login.this, "sussefully", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else
                    {
//                        Toast.makeText(Login.this, "Not find", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public  void fatchdata()
    {
        class  backthread extends AsyncTask<String,Void,String>
        {

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                try {

                    JSONObject jsonObject=new JSONObject();

                    JSONArray jsonArray= jsonObject.getJSONArray(s);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        String username= (String) jsonObject1.get("user");
                        String password= (String) jsonObject1.get("password");
                        setvalueinarrray set=new setvalueinarrray(username,password);
                        set.setUsername(username);
                        set.setPassword(password);
                        arrayList.add(set);
                    }

                    Toast.makeText(Login.this, "array"+arrayList.size(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception ex)
                {
                    ex.getMessage();
                }


            }

            @Override
            protected String doInBackground(String... strings) {

                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));


                    StringBuffer stringBuffer=new StringBuffer();
                    String line;
                    while ((line=bufferedReader.readLine())!=null)
                    {

                        stringBuffer.append(line+"\n");

                    }

                    bufferedReader.close();

                    return stringBuffer.toString();

                }
                catch (Exception ec)
                {
                    return ec.getMessage();
                }

            }
        }
    }

}