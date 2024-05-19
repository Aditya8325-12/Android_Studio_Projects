package com.example.longrunnningtask;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button longb1,sh;
    TextView text,thred;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        longb1=findViewById(R.id.longtask);
        sh=findViewById(R.id.show);
        text=findViewById(R.id.text);
        text2=findViewById(R.id.edittext);
        thred=findViewById(R.id.thred);
        longb1.setOnClickListener(this);
        sh.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.longtask:
                async a=new async();
                a.execute(thred);
            case R.id.show:
                String name=text2.getText().toString();
                text.setText("Name = "+name);
        }

    }

    public class async extends AsyncTask<TextView,String,Boolean>
    {
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(MainActivity.this);
//            pd.setMessage("Wiat process in running");
//            pd.setCancelable(false);
//            pd.show();
        }

        @Override
        protected Boolean doInBackground(TextView... textViews) {
            thred =textViews[0];
            int i=0;

            while (i++ <15)
            {
                try {
                    Thread.sleep(500);
                    publishProgress(String.format("value of i==%d",i));
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
            thred.setText(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
//            pd.hide();
            if (aBoolean)
            {
                thred.setText("task is completed");
            }
        }
    }

}