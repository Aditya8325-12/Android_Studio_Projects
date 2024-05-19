package com.example.autoapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button button;
    EditText editText;
    int num;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout =findViewById(R.id.lin);
        button =findViewById(R.id.enterr);
        editText =findViewById(R.id.edi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1;
                s1= editText.getText().toString();
                num=Integer.parseInt(s1);
                s="abc";
                createButton(num);
            }
        });



    }

    public  void createButton(int numberOfTimesToCreate)
    {
            for(int count=0;count<numberOfTimesToCreate;count++)
            {
                Button button=new Button(this);
                button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                button.setId(count);
                button.setGravity(Gravity.CENTER);
                String txt = "b"+count;
                button.setText(txt);
                linearLayout.addView(button);
            }


    }
}