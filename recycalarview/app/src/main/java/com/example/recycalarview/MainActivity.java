package com.example.recycalarview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<userdetails> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclarview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));
        arrayList.add(new userdetails(R.drawable.ic_launcher_background,"A","a"));

    }
}