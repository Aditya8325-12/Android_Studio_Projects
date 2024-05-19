package com.example.modifyjson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecoundActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    ArrayList<String> arrayList=new ArrayList<>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);


        textView=findViewById(R.id.textview);
        linearLayout=findViewById(R.id.linear);
        ListView listView=new ListView(this);

        Intent intent=new Intent();
        String s=intent.getStringExtra("string");

        textView.setText(""+s);
//        listView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
//        int ii=100;
//        listView.setId(ii);
//        try {
//            JSONArray jsonArray=new JSONArray(s);
//            for(int i=0;i< jsonArray.length();i++)
//            {
//                JSONObject jsonObject=jsonArray.getJSONObject(i);
//                String name=jsonObject.getString("name");
//                arrayList.add("value"+name);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(SecoundActivity.this, android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
//
//        linearLayout.addView(listView);


    }
}