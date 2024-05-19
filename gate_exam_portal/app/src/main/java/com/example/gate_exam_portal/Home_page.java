package com.example.gate_exam_portal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Home_page extends AppCompatActivity {


    Button chapter_wise_test,weekly_test,my_progress;

    SharedPreferences sharedPreferences;



    public  static int  user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        chapter_wise_test=findViewById(R.id.chapter_wise);
        weekly_test=findViewById(R.id.Weekly_test);
        my_progress=findViewById(R.id.MY_progress);

        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        if(sharedPreferences.contains("user") && sharedPreferences.contains("pass"))
        {
            String user=sharedPreferences.getString("user","");
            String pass=sharedPreferences.getString("pass","");
            String query="?t1=user&t2="+user+"&t3="+pass;
            get_the_data_from_url obj=new get_the_data_from_url();
            obj.execute(getString(R.string.path)+query);
        }



//        go to the chapter wise test
        chapter_wise_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_page.this,Test_list.class);
                intent.putExtra("test_name","Chapter_wise_test");
                startActivity(intent);
            }
        });

//       go to the  weekly_test
        weekly_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_page.this,Test_list.class);
                intent.putExtra("test_name","Weekly_test");
                startActivity(intent);
            }
        });

//        go to the myprogress
        my_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Home_page.this,MyProgress.class));
            }
        });

    }


//    show the menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
// menu option selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logout:
                SharedPreferences sharedPreferences;
                sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.remove("user");
                editor.remove("pass");
                editor.commit();
                Intent intent=new Intent(Home_page.this,login_page.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    class  get_the_data_from_url extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            try {

                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                    jsonObject=jsonArray.getJSONObject(0);
                    String id=(String) jsonObject.get("id");
                    user_id=Integer.parseInt(id);

            }
            catch (Exception ec)
            {
                ec.getMessage();
            }

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