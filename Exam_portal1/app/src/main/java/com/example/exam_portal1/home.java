package com.example.exam_portal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class home extends AppCompatActivity {



    ListView listView;
    public static ArrayList<String> arrayList=new ArrayList<>();
//    String path="https://gprep.000webhostapp.com/android_process.php?t1=Test_list";
    String path="http://192.168.155.37/gate_exam_version2/android_process.php?t1=Test_list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listView=(ListView) findViewById(R.id.test_list);
        process obj=new process();
        obj.execute(path);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(home.this,Test_instrucation.class);
                intent.putExtra("postion",i);
                startActivity(intent);
            }
        });
    }


    class  process extends AsyncTask<String,Void,String>
    {


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


                try {

                    JSONArray jsonArray=new JSONArray(s);
                    JSONObject jsonObject=null;
                    arrayList.clear();
                    for(int i=0;i< jsonArray.length();i++)
                    {
                        jsonObject=jsonArray.getJSONObject(i);
                        String Test_name=(String) jsonObject.get("testname");
                        arrayList.add(Test_name);
                    }
                }
                catch (Exception ec)
                {
                    ec.getMessage();
                }

            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(home.this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
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