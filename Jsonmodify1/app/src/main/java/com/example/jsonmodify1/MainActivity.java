package com.example.jsonmodify1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {



    TextView textView;

    String webUrl="https://jsonplaceholder.typicode.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textview);



        String s=getTheDataFromUrl(webUrl);


        asyntas asyntas=new asyntas();

        asyntas.execute(webUrl);


    }



    public  class asyntas extends AsyncTask<String,String,String>
    {


        @Override
        protected String doInBackground(String... strings) {

            String s=getTheDataFromUrl(webUrl);

            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            textView.setText("-------"+s);

        }
    }


    public  static String getTheDataFromUrl(String s)
    {
        URL url=null;
        HttpURLConnection httpURLConnection=null;

        try {
            url=new URL(s);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            BufferedInputStream  inputStream= (BufferedInputStream) httpURLConnection.getInputStream();
            InputStream inputStream1=new BufferedInputStream(inputStream);

            String ss=convertbytestostring(inputStream);
            return ss;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }

    public static String convertbytestostring(InputStream inputStream)
    {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder=new StringBuilder();

        try {
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