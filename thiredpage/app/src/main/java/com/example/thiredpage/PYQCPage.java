package com.example.thiredpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PYQCPage extends AppCompatActivity {


    Button createlist;
    ListView listView;
   public static ArrayList<String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyqcpage);

        createlist=findViewById(R.id.createList);
        listView=findViewById(R.id.listview);


        arrayList.clear();

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();


        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("PYQC");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if(snapshot.getValue()==null)
                {
                    Toast.makeText(PYQCPage.this, "Fuck off", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
                        arrayList.add("chapter");
                        arrayAdapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        createlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PYQCPage.this, admincreateList.class);
                intent.putExtra("pagereferance",1);
                startActivity(intent);
            }
        });


    }
}