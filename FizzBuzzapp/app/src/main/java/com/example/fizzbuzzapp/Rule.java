package com.example.fizzbuzzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Rule extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        text=findViewById(R.id.text);

        text.setText("dnss");
        String s="if Number is divisible by 3 than press fizz button \n" +
                " if number is divisible by 5 than press buzz button \n" +
                " if number is divisible  by both number than press fizzbuzz button \n" +
                " if number is not divisible both number than press next button \n\n" +
                " if You put wrong btn" +
                "\n ex .number is 19   number is not divisble by 3 or 5 \n" +
                "but you press fizz btn or fizz buzz btn \n\n  game will be restart or close the game \n" +
                "click YES for restart the game \n" +
                "click NO for exit the game ";
        try {
            FileOutputStream file=openFileOutput("rule.txt",MODE_PRIVATE);
            FileDescriptor fileo;
            file.write(s.getBytes());
            file.close();
            Toast.makeText(this, "Data save sussfuly ", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try {
            StringBuilder str=new StringBuilder();
            FileInputStream file=openFileInput("rule.txt");
            int r=0;
            while( (r= file.read())!=-1 )
            {
                    str.append( (char)r );
                            text.setText(""+str.toString());

            }
            file.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}