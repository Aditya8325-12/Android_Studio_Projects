package com.example.exam_portal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Test_instrucation extends AppCompatActivity {


    Button start;
    String path="https://gprep.000webhostapp.com/android_process.php?t1=Test";
    public  static ArrayList<Test_question> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_instrucation);

        Intent intent=getIntent();
        int s=intent.getIntExtra("postion",0);
        String query="&t2="+home.arrayList.get(s);
        process obj=new process();
        obj.execute(path+query);


        start=findViewById(R.id.Start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Test_instrucation.this,Test_page.class));
            }
        });



    }

    class process extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String s=convert_into_byte_to_string(bufferedReader);
                return  s;
            }
            catch (Exception ex)
            {
                return ex.getMessage();
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);



            try {
                JSONArray jsonArray= new JSONArray(s);
                JSONObject jsonObject=null;
                arrayList.clear();
                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String question_name=jsonObject.getString("question");
                    String option1=(String) jsonObject.get("option_1");
                    String option2=(String) jsonObject.get("option_2");
                    String option3=(String) jsonObject.get("option_3");
                    String option4=(String) jsonObject.get("option_4");
                    String correct=(String) jsonObject.get("correct");

                    Test_question test_question=new Test_question(question_name,option1,option2,option3,option4,correct);
                    arrayList.add(test_question);
                }
            }
            catch (Exception ex)
            {
                 ex.getMessage();
            }

        }
    }

    public String convert_into_byte_to_string(BufferedReader bufferedReader)
    {

        StringBuilder str=new StringBuilder();
        try {
            int i=bufferedReader.read();
            while(i!=-1)
            {
                str.append((char) i);
                i=bufferedReader.read();
            }
            return str.toString();
        } catch (IOException e) {
            return  e.getMessage();
        }
    }

}