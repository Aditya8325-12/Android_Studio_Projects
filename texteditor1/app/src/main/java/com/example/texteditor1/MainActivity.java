package com.example.texteditor1;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button SaveButton,LoadButton;
    EditText etext;
    TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SaveButton=findViewById(R.id.Save);
        etext=findViewById(R.id.edittext);
        tview=findViewById(R.id.textview);
        LoadButton=findViewById(R.id.Load);
        SaveButton.setOnClickListener(this);
        LoadButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Save:
                boolean chec= TextUtils.isEmpty(etext.getText().toString());
                if (chec==true)
                {
                    etext.setError("plese add some text");
                }
                if(chec==false)
                {
                    String s1=etext.getText().toString();
                    try {
                        FileOutputStream fileo=openFileOutput("text2.txt",MODE_PRIVATE);
                        File file=getFilesDir();
                        fileo.write(s1.getBytes());
                        fileo.close();
                        Toast.makeText(MainActivity.this, "file are sussefully save ", Toast.LENGTH_SHORT).show();
                        etext.setText("");
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                }
                break;
            case R.id.Load:
                StringBuilder str=new StringBuilder();
                try {
                    FileInputStream filei=openFileInput("text2.txt");
                    int r=0;
                    while((r=filei.read())!=-1)
                    {
                        str.append( (char)r );
                    }
                    tview.setText(tview.getText()+" "+str.toString());
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }
}