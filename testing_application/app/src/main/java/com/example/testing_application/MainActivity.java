
package com.example.testing_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    String path = "https://gprep.000webhostapp.com/android_process.php?t1=Test_list";
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        process obj=new process();
        obj.execute(path);
        text=findViewById(R.id.text);


    }


    class  process extends AsyncTask<String,Void,String>
    {


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            text.setText(""+s);

        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String s=convert_byte_to_string(bufferedReader);

                return s;
            }
            catch (Exception ex)
            {
                return ex.getMessage();
            }
        }
    }


    public String convert_byte_to_string(BufferedReader bufferedReader)
    {
        StringBuilder s=new StringBuilder();
        try {
            int i=bufferedReader.read();

            while (i!=-1)
            {
                s.append((char) i);
                i=bufferedReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }


}