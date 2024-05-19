package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivty extends AppCompatActivity {


    EditText email,password;
    Button register;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activty);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);


        firebaseAuth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString()))
                {
                    email.setError("please enter the value");
                    password.setError("please enter the value");
                }
                else
                {
                    String email1=email.getText().toString();
                    String password1=password.getText().toString();

                    firebaseAuth.createUserWithEmailAndPassword(email1,password1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(RegisterActivty.this, "sucsses", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivty.this, "failure", Toast.LENGTH_SHORT).show();
                        }
                    });

                    Intent intent=new Intent(RegisterActivty.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}