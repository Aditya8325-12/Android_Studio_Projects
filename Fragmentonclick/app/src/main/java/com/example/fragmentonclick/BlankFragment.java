package com.example.fragmentonclick;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlankFragment extends Fragment {


    View view;
    ListView listView;

    String[] strings=new String[]{
            "toc","sdf","sdf"
    };
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_blank, container, false);
        listView=view.findViewById(R.id.listt);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity().getApplicationContext(),SecoundClas.class);
                startActivity(intent);
            }
        });
        return view;
    }
}