package com.example.modifyjson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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


    String weburl = "https://jsonplaceholder.typicode.com/users";
    TextView textView, textView1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        button = findViewById(R.id.enter);
        asynk as = new asynk();
        as.execute(weburl);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecoundActivity.class);
                startActivity(intent);
            }
        });
    }


    public static class asynk extends AsyncTask<String, String, String> {
        URL url = null;
        HttpURLConnection httpURLConnection = null;

        @Override
        protected String doInBackground(String... strings) {


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);



        }

        public static String converttoString(InputStream inputStream) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            try {
                int i = bufferedReader.read();
                while (i != -1) {
                    stringBuilder.append((char) i);
                    i = bufferedReader.read();
                }

                return stringBuilder.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }


    }
}