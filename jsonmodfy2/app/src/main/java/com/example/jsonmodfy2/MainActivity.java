package com.example.jsonmodfy2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
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

    ListView listView;
    Button button;

    String webUrl="https://jsonplaceholder.typicode.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        button=findViewById(R.id.Enter);
        async a=new async();
        a.execute(webUrl);

    }
    public class async extends AsyncTask<String,Void,ArrayList>
    {
        HttpURLConnection httpURLConnection=null;
        URL url=null;

        ArrayList<String> arrayList2=new ArrayList<>();
        @Override
        protected ArrayList doInBackground(String... strings) {

            try {
                url=new URL(strings[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStream inputStream1=new BufferedInputStream(inputStream);
                String s=converetbute(inputStream1);


                JSONObject jsonObject=new JSONObject();

                JSONArray jsonArray= jsonObject.getJSONArray(s);
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);
                    String Name= (String) jsonObject1.get("name");

                    arrayList2.add(Name);
                }

                return arrayList2;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList arrayList) {
            super.onPostExecute(arrayList);
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
        }
    }

    public static String converetbute(InputStream inputStream){

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder=new StringBuilder();

        try {
            int i=bufferedReader.read();
            while (i!=-1)
            {
                stringBuilder.append((char) i);
                i=bufferedReader.read();
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}