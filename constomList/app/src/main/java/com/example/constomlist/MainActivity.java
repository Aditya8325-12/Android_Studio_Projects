package com.example.constomlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.StringSearch;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> head11=new ArrayList<>();
    ArrayList<String> head22=new ArrayList<>();

    String path="http://192.168.155.37/gate_exam_version2/android_process.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);


//        for test_list_name
        String query="?t1=Test_list&t2=Weekly_test";
        get_data_from_test_list obj=new get_data_from_test_list();
        obj.execute(path+query);
//        for user_completed test_list name
        String query2="?t1=record&t2=13&t3=Weekly_test";
        get_data_from_progress obj1=new get_data_from_progress();
        obj1.execute(path+query2);

        adapter myadpter=new adapter(this,head11,head22);
        listView.setAdapter(myadpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=listView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "s", Toast.LENGTH_SHORT).show();
            }
        });
    }


    class  adapter extends ArrayAdapter<String>{

        Context context;
        ArrayList<String> head11;

        ArrayList<String> head22;

        adapter(Context c,ArrayList<String> header1,ArrayList<String> header2)
        {
            super(c,R.layout.row,R.id.head1,header1);
            context=c;
            this.head11=header1;
            this.head22=header2;

            Toast.makeText(c, ""+head11.size(), Toast.LENGTH_SHORT).show();
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.row,parent,false);
            TextView text1=view.findViewById(R.id.head1);
            TextView text2=view.findViewById(R.id.head2);
            ImageView imageView=view.findViewById(R.id.img);
            LinearLayout layout=view.findViewById(R.id.linear);
            Toast.makeText(context, "fuck"+head11.size(), Toast.LENGTH_SHORT).show();
            if(head22.contains(head11.get(position)))
            {
                text1.setText(head11.get(position));
                text2.setText("complete");
                imageView.setImageResource(R.drawable.checked);
                layout.setBackgroundColor(Color.parseColor("#34C13A"));
            }
            else {
                text1.setText(head11.get(position));
                text2.setText("Not complete");
                layout.setBackgroundColor(Color.parseColor("#C31306"));
                imageView.setVisibility(View.GONE);
            }
            return view;
        }
    }


//    test_list
    class  get_data_from_test_list extends AsyncTask<String,Void,String>
    {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {

                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                head11.clear();
                for(int i=0;i< jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String Test_name=(String) jsonObject.get("testname");
                    head11.add(Test_name);
                }
                Toast.makeText(MainActivity.this, ""+head11.size(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception ec)
            {
                ec.getMessage();
            }

        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(3000);
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


//   user  progress

    class  get_data_from_progress extends AsyncTask<String,Void,String>
    {


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                head22.clear();

                for(int i=0;i< jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String Test_name=(String) jsonObject.get("test_name");
                    head22.add(Test_name);
                }
                Toast.makeText(MainActivity.this, ""+head22.size(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception ec)
            {
                ec.getMessage();
            }

        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(5000);
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