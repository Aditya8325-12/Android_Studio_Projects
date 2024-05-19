package com.example.filehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button save,load,clear;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.save);
        load=findViewById(R.id.load);
        editText=findViewById(R.id.edittext);
        textView=findViewById(R.id.text);
        clear=findViewById(R.id.clear);
        clear.setOnClickListener(this);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        boolean te= TextUtils.isEmpty(editText.getText().toString());
//        if(te=true)
//        {
//            editText.setError("plese fill the following details");
//        }
//        else
//        {
            switch (view.getId())
            {
                case R.id.save:
                    try {
                        FileOutputStream file=openFileOutput("text.txt",MODE_APPEND);
                        String str="\n"+editText.getText().toString();
                        file.write(str.getBytes());
                        file.close();
                        Toast.makeText(this, "file create and save the sussefully", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case R.id.load:
                    try {
                        FileInputStream file=openFileInput("text.txt");
                        StringBuilder str=new StringBuilder();
                        int r=0;
                        while (  (r= file.read()) !=-1 )
                        {
                            str.append((char)r);
                            textView.setText("\n"+str);
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case R.id.clear:
                       File fa=new File("text.txt");
                       fa.getFreeSpace();
                       textView.setText("");
                       break;


            }
//        }

    }
}