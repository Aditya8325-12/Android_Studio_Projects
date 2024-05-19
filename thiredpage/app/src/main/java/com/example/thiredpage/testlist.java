package com.example.thiredpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class testlist extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    String path;
    ArrayList<String> arrayList=new ArrayList<>();
    int pagereferance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlist);

        listView=findViewById(R.id.listview);
        toolbar=findViewById(R.id.Toolbar);


        Intent intent=getIntent();

        pagereferance=intent.getIntExtra("previousquestion",0);
        if(pagereferance==1)
        {
            toolbar.setTitle("PYQC");
            path="PYQC";
        }
        else if (pagereferance==2)
        {
            toolbar.setTitle("PYQCFinal");
            path="PYQCFinal";
        }
        else if (pagereferance==3){
            toolbar.setTitle("Final");
            path="Final";
        }


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();






        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if(snapshot.getValue()==null)
                {
                    Toast.makeText(testlist.this, "data not gate ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int i=0;
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
                        arrayList.add("chapter"+i);
                        arrayAdapter.notifyDataSetChanged();
                        i++;
                    }
                    i=0;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(testlist.this,TestInstrucation.class);
                intent1.putExtra("pagereferance",pagereferance);
                intent1.putExtra("position",position);
                startActivity(intent1);
            }
        });

    }
}