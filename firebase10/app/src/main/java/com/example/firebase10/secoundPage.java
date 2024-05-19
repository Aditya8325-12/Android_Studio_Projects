package com.example.firebase10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class secoundPage extends AppCompatActivity {

    EditText name,age;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound_page);

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);

        button=findViewById(R.id.addvalue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Object> m=new HashMap<>();

                m.put("name",name.getText().toString());
                m.put("age",age.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("student").push().setValue(m);
                Intent intent=new Intent(secoundPage.this,ThiredPage.class);
                startActivity(intent);
            }
        });
    }
}