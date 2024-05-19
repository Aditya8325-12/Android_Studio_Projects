package com.example.exam_portal1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sign extends AppCompatActivity {


    EditText user,pass;
    Button sign;
    String path="https://gprep.000webhostapp.com/android_process.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        user=findViewById(R.id.username);
        pass=findViewById(R.id.pass);

//        vaishanavi13105
        sign=findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals("")  && pass.getText().toString().equals("") )
                {
                    user.setError("plese fill the value");
                    pass.setError("plese fill the value");
                }
                else
                {

                    Toast.makeText(sign.this, "value has been proessd ", Toast.LENGTH_SHORT).show();

                    String username1=user.getText().toString();
                    String password1=pass.getText().toString();
                    String query="?t1=signup"+"&t2="+username1+"&t3="+password1;


                    class  process extends AsyncTask<String ,Void,String>
                    {
                        @Override
                        protected String doInBackground(String... strings) {
                            try {
                                URL url=new URL(strings[0]);
                                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                return  bufferedReader.readLine();
                            }
                            catch (Exception ec)
                            {
                                return ec.getMessage();
                            }
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            user.setText("");
                            pass.setText("");
                            Toast.makeText(sign.this, "s"+s, Toast.LENGTH_SHORT).show();
                        }
                    }


                    process obj=new process();
                    obj.execute(path+query);
                }
            }
        });
    }
}