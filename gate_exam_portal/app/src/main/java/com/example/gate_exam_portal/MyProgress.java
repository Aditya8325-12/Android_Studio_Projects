package com.example.gate_exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyProgress extends AppCompatActivity  {


    Button chapter_record,weekly_record;
    ListView listView;
    ArrayList<String> list_data=new ArrayList<>();

    public  static  ArrayList<record_class> save_data=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress);

        chapter_record=findViewById(R.id.chapter_record);
        weekly_record=findViewById(R.id.weekly_record);
        listView=findViewById(R.id.listview);




        chapter_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int user_id=Home_page.user_id;
                String query="?t1=record&t2="+user_id+"&t3=Chapter_wise_test";
                get_data_from_url obj=new get_data_from_url();
                obj.execute(getString(R.string.path)+query);
            }
        });

        weekly_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int user_id=Home_page.user_id;
                String query="?t1=record&t2="+user_id+"&t3=Weekly_test";
                get_data_from_url obj=new get_data_from_url();
                obj.execute(getString(R.string.path)+query);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MyProgress.this,user_test_record_page.class);
                intent.putExtra("postion",i);
                startActivity(intent);
            }
        });
    }


    class  get_data_from_url extends AsyncTask<String,Void,String>
    {


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                list_data.clear();
                save_data.clear();
                for(int i=0;i< jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String Test_name=(String) jsonObject.get("test_name");
                    String Test_type=(String) jsonObject.get("Test_type");
                    String Total_marks=(String) jsonObject.get("Total_marks");
                    String Total_question=(String) jsonObject.get("Total_question");
                    String marks_obtain=(String) jsonObject.get("marks_obtain");
                    String u_id=(String) jsonObject.get("id");
                    String id=(String) jsonObject.get("user_id");
                    list_data.add(Test_name);
                    record_class record_data=new record_class(Test_name,Test_type,Total_marks,Total_question,marks_obtain,id,u_id);
                    save_data.add(record_data);
                }
                Toast.makeText(MyProgress.this, "size"+save_data.size(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception ec)
            {
                ec.getMessage();
            }

            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MyProgress.this, android.R.layout.simple_list_item_1,list_data);
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