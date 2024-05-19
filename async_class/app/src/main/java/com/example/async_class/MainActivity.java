package com.example.async_class;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    ArrayList<String> test_name=new ArrayList<>();
    ArrayList<String> user_test_name=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

//        for test_list_name
        String query="?t1=Test_list&t2=Weekly_test";
        get_data_from_url obj=new get_data_from_url();
        obj.execute(getString(R.string.path)+query);

        String query2="?t1=record&t2=11&t3=Weekly_test";
        get_data_from_record obj_record=new get_data_from_record();
        obj_record.execute(getString(R.string.path)+query2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=listView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "s"+s, Toast.LENGTH_SHORT).show();
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
                test_name.clear();
                for(int i=0;i< jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String Test_name=(String) jsonObject.get("testname");
                    test_name.add(Test_name);
                }
                Toast.makeText(MainActivity.this, "test_name"+test_name.size(), Toast.LENGTH_SHORT).show();

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

    class  get_data_from_record extends AsyncTask<String,Void,String>
    {


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                user_test_name.clear();
                for(int i=0;i< jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String Test_name=(String) jsonObject.get("test_name");
                    user_test_name.add(Test_name);
                }
                Toast.makeText(MainActivity.this, "sadf"+user_test_name.size(), Toast.LENGTH_SHORT).show();


                adapter myadpter=new adapter(getApplicationContext(),test_name,user_test_name);
                listView.setAdapter(myadpter);


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



}