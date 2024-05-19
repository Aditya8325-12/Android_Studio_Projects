package com.example.firebase10;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Security;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText username,password;
    Button button;

    DatabaseReference databaseReference;
    ArrayList<String> admindata=new ArrayList<>();
    ArrayList<Security> securities=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        button=findViewById(R.id.Login);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String username1=username.getText().toString();
                String password1=password.getText().toString();

                databaseReference= FirebaseDatabase.getInstance().getReference("admin");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            String query=dataSnapshot.getValue(String.class);
                            admindata.add(query);
                        }


                        if(admindata.get(0).equals(password1) && admindata.get(1).equals(username1))
                        {
                            Intent intent=new Intent(MainActivity.this,secoundPage.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "user name and password is Incorrect", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.nebu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.addsecurity:
                Intent intent=new Intent(MainActivity.this,Eraaddvalue.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}