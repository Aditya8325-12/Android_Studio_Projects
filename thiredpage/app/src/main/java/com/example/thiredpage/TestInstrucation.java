package com.example.thiredpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TestInstrucation extends AppCompatActivity {

    Button start;
    String path;

    public  static ArrayList<questionclass> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_instrucation);

        start=findViewById(R.id.Start);

        arrayList.clear();

        Intent intent=getIntent();
        int postion=intent.getIntExtra("position",0);
        int pagereferance=intent.getIntExtra("pagereferance",0);

        if(pagereferance==1)
        {
            path="PYQC/chapter"+postion;
        }
        else if (pagereferance==2)
        {
            path="PYQCFinal/chapter"+postion;
        }
        else if (pagereferance==3){
            path="Final/chapter"+postion;
        }

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if(snapshot.getValue()==null)
                {
                    Toast.makeText(TestInstrucation.this, "data will null" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
                        questionclass questionclassa=dataSnapshot.getValue(questionclass.class);
                        arrayList.add(questionclassa);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestInstrucation.this, testClass.class);
                startActivity(intent);
            }
        });
    }
}