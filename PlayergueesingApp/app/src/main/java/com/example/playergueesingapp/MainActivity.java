package com.example.playergueesingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    LinearLayout linearLayout;

    String[] PlayerName={"DHONI","SACHIN","VIRAT","ROHIT","RAHUL","HARDIK"};
    int PressCounter=0;
    int MaxPressCounter=PlayerName[0].length();

    int score=0;
    int count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittext);
        linearLayout=findViewById(R.id.linear);


        addView(linearLayout,PlayerName[0],editText);


    }

    public void  addView(LinearLayout linearLayout,String text,EditText editText)
    {
       LinearLayout.LayoutParams  linLayoutParams= new LinearLayout.LayoutParams(140,140);
        linLayoutParams.rightMargin=20;
        String newtext=Stringshuffle(text);

        for(int i=0;i<newtext.length();i++)
        {
            char CurrentChar=newtext.charAt(i);
            Button button=new Button(this);
            button.setLayoutParams(linLayoutParams);
            button.setText(""+String.valueOf(CurrentChar));
            button.setId(i);
            button.setBackgroundResource(R.drawable.shape);
            button.setTextSize(15f);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PressCounter++;
                    if(PressCounter==0)
                    {
                        editText.setText("");
                    }
                    else
                    {
                        editText.setText(editText.getText().toString()+""+String.valueOf(CurrentChar));
                    }

                    button.animate().alpha(0).setDuration(300);

                    button.setVisibility(View.INVISIBLE);
                    if(PressCounter==MaxPressCounter)
                    {
                        doValidate(editText,text);
                    }
                }
            });

            linearLayout.addView(button);
        }


    }


    public void  doValidate(EditText editText,String text)
    {

        if(editText.getText().toString().equals(text))
        {
            Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
            editText.setText("");
            count++;
            score++;
//            Toast.makeText(this, "+"+score, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
            count++;
        }

        if(count==6)
        {
            Intent intent=new Intent(MainActivity.this,result.class);
            intent.putExtra("score",score);
            startActivity(intent);
            score=0;
        }



            linearLayout.removeAllViews();
                PressCounter=0;
                MaxPressCounter=PlayerName[count].length();
                addView(linearLayout,PlayerName[count],editText);


    }


    public  String Stringshuffle(String text){

        ArrayList<Character> characterArrayList=new ArrayList<>();

        for( char c:text.toCharArray() )
        {
                characterArrayList.add(c);
        }
        StringBuilder s=new StringBuilder();
        while (characterArrayList.size() != 0 )
        {
            int index=(int) (Math.random()*characterArrayList.size());
            s.append(characterArrayList.remove(index));
        }
        return s.toString();
    }
}