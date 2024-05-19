package com.example.firebase10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Eraaddvalue extends AppCompatActivity {


    EditText name,password,age;
    Button addvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eraaddvalue);

        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        age=findViewById(R.id.age);

        addvalue=findViewById(R.id.addvalue);


        addvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1=name.getText().toString();
                String password1=password.getText().toString();
                String age1=age.getText().toString();

                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("addvalue");
                String id=databaseReference.push().getKey();
                Advalue advalue=new Advalue(name1,age1,password1);
                databaseReference.child(id).setValue(advalue);
                Toast.makeText(Eraaddvalue.this, "add thevalue is sussefull", Toast.LENGTH_SHORT).show();
                name.setText("");
                age.setText("");
                password.setText("");

                Intent intent=new Intent(Eraaddvalue.this,ThiredPage.class);
                startActivity(intent);

            }
        });
    }
}