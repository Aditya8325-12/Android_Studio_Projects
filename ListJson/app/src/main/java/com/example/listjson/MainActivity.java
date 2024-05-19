package com.example.listjson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
    ListView listView;
    String url="https://jsonplaceholder.typicode.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        async as=new async();
        as.execute(url);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,SecoundPage.class);
                int postion=i;
                intent.putExtra("value",String.valueOf(i));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.addlist:
                Intent i=new Intent(MainActivity.this,Addlistview.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public  class async extends AsyncTask<String,String, ArrayList<String>>
    {

        URL url=null;
        HttpURLConnection httpURLConnection=null;

        ArrayList<String> arrayList=new ArrayList<>();

        @Override
        protected ArrayList<String> doInBackground(String... strings) {

            try {

//                get The Data From url In From of Byte
                url=new URL(strings[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStream inputStream1=new BufferedInputStream(inputStream);
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream1));

//                convert the data from byte to String
                int i=bufferedReader.read();
                StringBuilder stringBuilder=new StringBuilder();
                while (i!=-1)
                {
                    stringBuilder.append((char) i);
                    i=bufferedReader.read();
                }
                String getTheDataFromUrl=stringBuilder.toString();

//                get the spaceific data from json file
                JSONArray jsonArray=new JSONArray(getTheDataFromUrl);
                for(int value=0;value<jsonArray.length();value++)
                {
                    JSONObject jsonObject= jsonArray.getJSONObject(value);
                    String name=(String) jsonObject.getString("name");
                    arrayList.add(name);
                }

                return arrayList;

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
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
        }
    }



}