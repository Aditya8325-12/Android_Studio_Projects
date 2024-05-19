package com.example.thiredpage;

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

public class Register extends AppCompatActivity {


    Button register;
    EditText username,password,name,quaification,department,collegename,mobile,dob,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        quaification=findViewById(R.id.qualification);
        department=findViewById(R.id.department);
        collegename=findViewById(R.id.College);
        mobile=findViewById(R.id.mobile);
        dob=findViewById(R.id.DOB);
        email=findViewById(R.id.Email);


        //for Button
        register=findViewById(R.id.register);


        //button on click Listnear
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().equals(null) && password.getText().equals("") && name.getText().equals("") && quaification.getText().equals("") && department.getText().equals("")
                    && collegename.getText().equals("") && mobile.getText().equals("") && dob.getText().equals("") && email.getText().equals(""))
                {
                    username.setText("please Enter the Value");
                    password.setText("please Enter the Value");
                    name.setText("please Enter the Value");
                    email.setText("please Enter the Value");
                    mobile.setText("please Enter the Value");
                    department.setText("please Enter the Value");
                    collegename.setText("please Enter the Value");
                    dob.setText("please Enter the Value");
                    quaification.setText("Please Enter the value");
                }
                else
                {
                    String name1=name.getText().toString();
                    String password1=password.getText().toString();
                    String username1=username.getText().toString();
                    String email1=email.getText().toString();
                    String Department1=department.getText().toString();
                    String college1=collegename.getText().toString();
                    String dob1=dob.getText().toString();
                    String qualifiaction=quaification.getText().toString();
                    String mobile1=mobile.getText().toString();


                    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("StudentRegistration");
                    StudentRegistration studentRegistration=new StudentRegistration(name1,username1,password1,qualifiaction,Department1,college1,mobile1,dob1,email1);
                    String id=databaseReference.push().getKey();
                    databaseReference.child(id).setValue(studentRegistration);


                    Toast.makeText(Register.this, "From is Sussefully opem", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Register.this,Login.class);
                    startActivity(intent);
                }
            }
        });
    }
}