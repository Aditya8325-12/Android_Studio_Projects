package com.example.loginpagesample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView register;
    EditText username,password;
    Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register=findViewById(R.id.Registe);
        login=findViewById(R.id.Login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                getDatabaseValueInArrayList();
//                for(int i=0;i<arrayList.size();i++)
//                {
//                    if(arrayList.get(i).getUsername().equals(name) && arrayList.get(i).getPassword().equals(pass))
//                    {
//                        String name12=arrayList.get(i).getName();
//                        String email12=arrayList.get(i).getEmail();
//
//
//                        Toast.makeText(MainActivity.this, "Login sucsesfull", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(MainActivity.this,Home.class);
//                        intent.putExtra("name",name12);
//                        intent.putExtra("email",email12);
//                        startActivity(intent);
//                        break;
//                    }
//                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

    }



    public  void  getDatabaseValueInArrayList()
    {

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("StudentRegistration");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.getValue()==null)
                {
                    Toast.makeText(MainActivity.this, "Plese connect to the Internet", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
//                        StudentRegistration student=dataSnapshot.getValue(StudentRegistration.class);
//                        arrayList.add(student);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}