package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText username,password;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        enter=findViewById(R.id.eneter);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=username.getText().toString();
                String pass=password.getText().toString();

                student student=new student(name,pass);
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("student");
                String id=databaseReference.push().getKey();
                databaseReference.child(id).setValue(student);
                Toast.makeText(MainActivity.this, "data add sussefully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Secoundpage.class);
                startActivity(intent);

                username.setText("");
                password.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.login:
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}