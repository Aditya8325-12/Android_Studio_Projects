package com.example.gate_exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class result_page extends AppCompatActivity {

    TextView t_question,correct,t_marks,ts_name,ts_type,user_id;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);


        t_question=findViewById(R.id.total_question);
        correct=findViewById(R.id.correct);
        t_marks=findViewById(R.id.total_marks);
        ts_name=findViewById(R.id.test_name);
        ts_type=findViewById(R.id.test_type);
        user_id=findViewById(R.id.user_id);

        Intent intent=getIntent();
        int correct_question=intent.getIntExtra("correct",0);
        int total_question= Test_instrucation.question.size();

        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        int postion=sharedPreferences.getInt("postion",0);

        t_question.setText("Total Question ="+total_question);
        correct.setText("Correct Answer = "+correct_question);
        t_marks.setText("Total marks ="+total_question);
        ts_name.setText("Test_name="+ Test_list.testInfo.get(postion).getTest_name());
        ts_type.setText("Test_type="+Test_list.testInfo.get(postion).getTest_type());
        user_id.setText("user_id="+ Home_page.user_id);
        String path="?t1=test_result&t2="+Test_list.testInfo.get(postion).getTest_name()+"&t3="+Test_list.testInfo.get(postion).getTest_type()+"&t4="+total_question+"&t5="+total_question+"&t6="+correct_question+"&t7="+Home_page.user_id;

        send_data_to_url onk2=new send_data_to_url();
        onk2.execute(getString(R.string.path)+path);


//        wrong.setText("Wrong Answer="+wrong_question);

    }


    class send_data_to_url extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                return  bufferedReader.readLine();
            }catch (Exception e)
            {
                return e.getMessage();
            }
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(result_page.this, "Register Done", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(result_page.this,Home_page.class);
        startActivity(intent);
    }



}