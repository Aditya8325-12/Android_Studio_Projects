package com.example.creatingmultiedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    EditText editText;
    Button button;

    ArrayList<EditText> editTexts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edit);
        button=findViewById(R.id.enter);
        button.setOnClickListener(this);





        Button button=new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        button.setText("enter");
        int i=0;
        button.setId(Integer.parseInt("bb"+i));
        button.setBackgroundColor(Color.BLUE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] s=new String[5];
                s=getingtextvalue();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout.addView(button);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.enter:
                boolean CheckValue= TextUtils.isEmpty(editText.getText().toString());
                if(CheckValue==true)
                {
                    editText.setError("please enter the value");
                }
                else
                {
                    int str=Integer.parseInt(editText.getText().toString());
                    Creatingtextview(str);
//                    Creatingbutton();

                }
                break;
        }
    }

    public  void Creatingtextview(int n)
    {

        for(int creatingtextviews=1;creatingtextviews<=n;creatingtextviews++)
        {
            EditText editText=new EditText(this);
            editText.setLayoutParams(new LinearLayout.LayoutParams(800,LinearLayout.LayoutParams.WRAP_CONTENT));
            editText.setHint("enter no "+creatingtextviews);
            editTexts.add(editText);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            editText.setId(creatingtextviews);
            linearLayout.addView(editText);
        }
    }

//    public  void Creatingbutton()
//    {
//        Button button=new Button(this);
//        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
//        button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//        button.setText("enter");
//        int buttonId=100;
//        button.setId(buttonId);
//        button.setBackgroundColor(Color.BLUE);
//        button.setOnClickListener((View.OnClickListener) this);
//        linearLayout.addView(button);
//    }


}