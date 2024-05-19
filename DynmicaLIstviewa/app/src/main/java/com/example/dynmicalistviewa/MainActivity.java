
package com.example.dynmicalistviewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    Button button;
    EditText editText;
    Createayout myonj=Createayout.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        linearLayout=findViewById(R.id.linear);
        editText=findViewById(R.id.Edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size=Integer.parseInt(editText.getText().toString());
                for(int i=1;i<=size;i++)
                {
                    EditText editText=new EditText(MainActivity.this);
                    linearLayout.addView(myonj.CreateEditText(editText,i));
                }
                Button button1=new Button(MainActivity.this);
                linearLayout.addView(myonj.CreateAButton(button1));
                button1.setOnClickListener(MainActivity.this);
            }
        });

    }

    @Override
    public void onClick( View view) {
        switch (view.getId())
        {
            case 2001:
                Intent intent=new Intent(MainActivity.this,newActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Button is created ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}