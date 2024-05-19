package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TextView textView;


    String jsonobjectedata="{\n" +
            "    \"student\":\n" +
            "    [{\n" +
            "            \"Name\":\"aditya\",\n" +
            "            \"class\":\"Cse\",\n" +
            "            \"Roll No\":2106\n" +
            "        \n" +
            "    },\n" +
            "    {\n" +
            "            \"Name\":\"abhi\",\n" +
            "            \"class\":\"Cse\",\n" +
            "            \"Roll No\":2102\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    ]\n" +
            "\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.JSONDATA);
        getjsondata();





    }



    public void getjsondata()
    {
        try {
            JSONObject jsonObject = new JSONObject(jsonobjectedata);
            JSONArray jsonArray = jsonObject.getJSONArray("student");

            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                String name=jsonObject1.getString("Name");
                String classname=jsonObject1.getString("class");

                textView.append("\n name :"+name+"\n className : "+classname);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}