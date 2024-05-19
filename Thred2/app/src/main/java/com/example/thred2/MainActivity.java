package com.example.thred2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.channels.AsynchronousChannelGroup;
import java.text.Format;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button longb1,showb2;
    EditText edittext1;
    TextView thred,text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longb1=findViewById(R.id.longtask);
        showb2=findViewById(R.id.show);
        edittext1=findViewById(R.id.edittext);
        thred=findViewById(R.id.thred);
        text1=findViewById(R.id.textshow);

        longb1.setOnClickListener(this);
        showb2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.longtask:
                asyn a=new asyn();
                a.execute(thred);
                break;
            case R.id.show:
                String s1=edittext1.getText().toString();
                text1.setText(s1);

        }
    }


    public class asyn extends AsyncTask<TextView,String,Boolean>
    {
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(MainActivity.this);
            pd.setCancelable(false);
            pd.setMessage("on progreess");
            pd.show();
        }

        @Override
        protected Boolean doInBackground(TextView... textViews) {
            thred=textViews[0];
            int i=0;
            while(i++ <15)
            {
                try {
                    Thread.sleep(500);
                    publishProgress(String.format("value of i == %d",i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return true;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            thred.setText(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            pd.hide();
            if(aBoolean)
            {
                    thred.setText("Task is completed");
            }
        }
    }
}