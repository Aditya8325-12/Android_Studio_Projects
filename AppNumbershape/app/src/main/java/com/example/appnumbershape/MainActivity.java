package com.example.appnumbershape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button enter;
    EditText enternum;
    TextView S,T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter=findViewById(R.id.enter);
        enternum=findViewById(R.id.enumber);
        S=findViewById(R.id.sqaretext);
        T=findViewById(R.id.trangletext);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checknum= TextUtils.isEmpty(enternum.getText().toString());
                if(checknum==true)
                {
                    enternum.setError("please enter the value");
                }
                else
                {
                    double num= Double.parseDouble(enternum.getText().toString());
                    chtrangle(num);
                    chsqare(num);

                    if(chtrangle(num))
                    {
                        T.setText("number is Trangular ");

                    }
                    else
                    {
                        T.setText("number is not TNrangular ");
                    }
                    if(chsqare(num))
                    {
                        S.setText("number is square ");

                    }
                    else
                    {
                        S.setText("number is not Square ");
                    }
                    enternum.setText("");
                }
            }
        });
    }

    public  boolean chtrangle(double n)
    {
            int sum=0;
            for(int i=1;sum<=n;i++)
            {
                sum=sum+i;
                if(n==sum)
                {
                    return true;
                }
            }

            return false;
    }

    public boolean chsqare(double n)
    {
        double num=Math.sqrt(n);
        if(num == Math.floor(num))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}