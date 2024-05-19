package com.example.thiredpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class homefragement extends Fragment {
    View view;
    ListView listView;



    public homefragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_homefragement, container, false);
        listView=view.findViewById(R.id.list);

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("TOC");
        arrayList.add("DBMS");
        arrayList.add("Digigtal Logic");
        arrayList.add("COA");
        arrayList.add("EM");
        arrayList.add("GA");
        arrayList.add("PDSA");
        arrayList.add("CD");
        arrayList.add("CN");
        arrayList.add("OS");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity().getApplicationContext(),afterHomepage.class);
                startActivity(intent);
            }
        });

        return view;
    }
}