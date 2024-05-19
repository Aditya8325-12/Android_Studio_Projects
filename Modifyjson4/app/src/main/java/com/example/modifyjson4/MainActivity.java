package com.example.modifyjson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String webUrl="https://jsonplaceholder.typicode.com/users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);


        async as=new async();
        as.execute(webUrl);

    }


    public  class async extends AsyncTask<String,String,String>
    {
        HttpURLConnection httpURLConnection=null;
        URL url=null;
        @Override
        public String doInBackground(String... strings) {
            try {
                url=new URL(strings[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStream inputStream1=new BufferedInputStream(inputStream);
                String s=convertthedata(inputStream1);

                return s;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(String s) {
            super.onPostExecute(s);


            try {
                JSONArray jsonArray=new JSONArray(s);
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    String name=jsonObject.getString("name");
                    textView.setText(textView.getText().toString()+"\n"+name);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }


    public static   String convertthedata(InputStream inputStream)
    {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        try {
            StringBuilder stringBuilder=new StringBuilder();
            int i=bufferedReader.read();
            while (i!=-1)
            {
                stringBuilder.append((char)i );
                i=bufferedReader.read();

            }

            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}