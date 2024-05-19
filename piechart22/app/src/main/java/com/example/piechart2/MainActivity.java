package com.example.piechart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout linearLayout;
    ArrayList<EditText> alledittexts=new ArrayList<>();
    EditText parts;
    Button enterpartsbutton;
    TextView textView;
    String s=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textview);
        linearLayout=findViewById(R.id.linear);
        parts=findViewById(R.id.parts);
        enterpartsbutton=findViewById(R.id.entervalue);
        enterpartsbutton.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.entervalue:
                    int n=Integer.parseInt(parts.getText().toString());
                    creatingedittext(n);
                    createbutton();
                    break;
            case 101:
                int size=alledittexts.size();
                for(int i=0;i<=size;i++)
                {
//                    s=alledittexts.get(i).getText().toString();
                    alledittexts.get(i).setText("0");
                }
                break;


        }
    }


    public  void creatingedittext(int n)
    {


        for(int i=1;i<=n;i++)
        {
            EditText editText=new EditText(this);
            editText.setLayoutParams(new LinearLayout.LayoutParams(400,200));
            editText.setHint("enternumber"+i);
            editText.setId(i);
            alledittexts.add(editText);
            linearLayout.addView(editText);

        }
    }



    public void createbutton()
    {
        Button button=new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setText("enter no2");
        int ii=1;
        button.setId(100+ii);
        button.setOnClickListener((View.OnClickListener)this );
        linearLayout.addView(button);
    }


}