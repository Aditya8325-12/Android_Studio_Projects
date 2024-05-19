package com.example.createautopiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    LinearLayout linearLayout1,linearLayout2,linearLayout;
    Button button;
    EditText editText;
    CreateALayout myonj=CreateALayout.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        linearLayout1=findViewById(R.id.linear1);
        linearLayout2=findViewById(R.id.linear2);
        linearLayout=findViewById(R.id.linear);
        editText=findViewById(R.id.Edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size=Integer.parseInt(editText.getText().toString());
                for(int i=1;i<=size;i++)
                {
                    EditText editTextLabel=new EditText(MainActivity.this);
                    linearLayout2.addView(myonj.CreateEditTextLabel(editTextLabel,i));

                    EditText editTextValue=new EditText(MainActivity.this);
                    linearLayout1.addView(myonj.CreateEditTextValue(editTextValue,i));


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
                Intent intent=new Intent(MainActivity.this,CreateAPieChart.class);
                startActivity(intent);
                Toast.makeText(this, "Button is created ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}