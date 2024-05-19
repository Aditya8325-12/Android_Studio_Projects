package com.example.shardpreferanse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button enter;
    EditText username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.userName);
        password=findViewById(R.id.PassWord);
        enter=findViewById(R.id.enter);




        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean usercheck= TextUtils.isEmpty(username.getText().toString());
                boolean passcheck= TextUtils.isEmpty(password.getText().toString());

                if(passcheck==true && usercheck==true)
                {
                    username.setError("Please fill the value");
                    password.setError("Please fill the value");
                }
                else
                {

                    String usertext=username.getText().toString();
                    String passtext=password.getText().toString();

                    SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("user",usertext);
                    editor.putString("pass",passtext);
                    editor.commit();
                    Intent intent=new Intent(MainActivity.this,NewActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item1:
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
