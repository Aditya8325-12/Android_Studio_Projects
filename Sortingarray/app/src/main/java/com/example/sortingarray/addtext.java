package com.example.sortingarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class addtext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtext);

        Button pls;
        EditText etext;
        TextView tview;

        pls=findViewById(R.id.add);
        etext=findViewById(R.id.edittext);
        pls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chec= TextUtils.isEmpty(etext.getText().toString());
                if (chec==true)
                {
                    etext.setError("plese add some text");
                }
                if(chec==false)
                {
                    String str=etext.getText().toString();
                    try {
                        FileOutputStream fileo=openFileOutput("algo.txt",MODE_PRIVATE);
                        File file=getFilesDir();
                        fileo.write(str.getBytes());
                        fileo.close();
                        Toast
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }

                }

            }
        });

    }
}