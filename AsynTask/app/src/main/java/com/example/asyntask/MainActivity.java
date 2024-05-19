package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button donotclickme,clickme;
    TextView textView,threadtext;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threadtext=findViewById(R.id.threadtext);
        textView=findViewById(R.id.textview);
        donotclickme=findViewById(R.id.donotclickme);
        clickme=findViewById(R.id.clickMe);
        editText=findViewById(R.id.editText);


        donotclickme.setOnClickListener(this);
        clickme.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.donotclickme:
                    Asyn asyn=new Asyn();
                    asyn.execute(threadtext);
                    break;
            case R.id.clickMe:
                String s=editText.getText().toString();
                textView.setText(""+s);
                editText.setText("");
                break;
        }

    }

    public  class Asyn extends AsyncTask<TextView,String,Boolean>{

        @Override
        protected Boolean doInBackground(TextView... textViews) {
            int i=0;
            threadtext=textViews[0];
            while(i<=15)
            {
                try {
                    publishProgress(String.format("value of %d ",i));
                    Thread.sleep(500);
                    i++;
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            threadtext.setText(""+values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean)
            {
                Toast.makeText(MainActivity.this, "--------------------------------", Toast.LENGTH_SHORT).show();
            }
        }
    }

}