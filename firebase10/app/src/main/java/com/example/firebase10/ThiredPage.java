package com.example.firebase10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ThiredPage extends AppCompatActivity {


    ListView listView;
    ArrayList<Advalue> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thired_page);


        listView=findViewById(R.id.listview);

        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("addvalue");
        arrayAdapter=new ArrayAdapter(ThiredPage.this,R.layout.items,arrayList);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.getValue()==null)
                {
                    Toast.makeText(ThiredPage.this, "fuck off", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
                        Advalue advalue=dataSnapshot.getValue(Advalue.class);
                        arrayList.add(advalue);
                    }


                    Toast.makeText(ThiredPage.this, ""+arrayList.get(0).getPassword(), Toast.LENGTH_SHORT).show();
                    arrayAdapter.notifyDataSetChanged();
                    listView.setAdapter(arrayAdapter);

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


     }
}