package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Secoundpage extends AppCompatActivity {


    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secoundpage);

        listView=findViewById(R.id.listview);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("student");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if(snapshot.getValue()==null)
                {
                    Toast.makeText(Secoundpage.this, "it is an empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
                        student student=dataSnapshot.getValue(com.example.firebasedatabase.student.class);
                        String s=student.getName()+"adit"+student.getUsername();
                        arrayList.add(s);
                    }

                    arrayAdapter=new ArrayAdapter(Secoundpage.this,R.layout.items,arrayList);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}