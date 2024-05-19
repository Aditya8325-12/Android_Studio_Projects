package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Login extends AppCompatActivity {


    EditText username,password;
    Button Login;

    ArrayList<student> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        Login=findViewById(R.id.Login);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                getDatabaseValueInArrayList();


                for(int i=0;i<arrayList.size();i++)
                {

                    if(arrayList.get(i).getName().equals(name) && arrayList.get(i).getUsername().equals(pass))
                    {

                        Toast.makeText(Login.this, "Login ssss", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(com.example.firebasedatabase.Login.this,AfterLogin.class);
                        startActivity(intent);
                        break;
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Name :"+arrayList.get(i).getName()+"+++ name---"+name+"--- Password :"+arrayList.get(i).getUsername()+"--pass---"+pass, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }



    public  void  getDatabaseValueInArrayList()
    {

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("student");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if(snapshot.getValue()==null)
                {
                    Toast.makeText(Login.this, "Plese connect to the Internet", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {

                        student student=dataSnapshot.getValue(com.example.firebasedatabase.student.class);
                        arrayList.add(student);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}