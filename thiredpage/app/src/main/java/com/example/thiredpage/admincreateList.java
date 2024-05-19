package com.example.thiredpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.thiredpage.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admincreateList extends AppCompatActivity {

    Button addthequestion,next,enter;
    LinearLayout linearLayout;
    ScrollView scrollView;
    EditText question,option1,option2,option3,option4,correct,howmanyquestion;
    TextView questionnocount;
    Toolbar toolbar;
    String path;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincreate_list);

        howmanyquestion=findViewById(R.id.howmanyquestion);
        toolbar=findViewById(R.id.Toolbar);
        linearLayout=findViewById(R.id.linear1);
        scrollView=findViewById(R.id.scroll1);
        question=findViewById(R.id.question);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        correct=findViewById(R.id.correct);
        questionnocount=findViewById(R.id.questionnumbercount);
        addthequestion=findViewById(R.id.addthequestion);
        next=findViewById(R.id.addquestion);
        enter=findViewById(R.id.enter);



        Intent intent=getIntent();
        int pagereferance=intent.getIntExtra("pagereferance",0);


        if(pagereferance==1)
        {
            int i=PYQCPage.arrayList.size();
            toolbar.setTitle("PYQC");
            path="PYQC/chapter"+i++;
        }
        else if (pagereferance==2)
        {
            int i=PYQCFinalPage.arrayList.size();
            toolbar.setTitle("PYQCFinal");
            path="PYQCFinal/chapter"+i++;
        }
        else if (pagereferance==3){
            int i=FinalPage.arrayList.size();
            toolbar.setTitle("Final");
            path="Final/chapter"+i++;
        }




        addthequestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                count++;
                questionnocount.setText("question"+count+"out of "+Integer.parseInt(howmanyquestion.getText().toString()));
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.getText().equals("") && correct.getText().equals("") && option1.getText().equals("") && option2.getText().equals("") && option3.getText().equals("") && option4.getText().equals("") )
                {
                    question.setText("PLese Enter the value");
                    correct.setText("PLese enter the value");
                    option1.setText("plese enter the value");
                    option2.setText("plese enter the value");
                    option3.setText("plese enter the value");
                    option4.setText("plese enter the value");
                }
                else
                {
                    if(count==Integer.parseInt(howmanyquestion.getText().toString()))
                    {

                        next.setVisibility(View.GONE);
                        enter.setVisibility(View.VISIBLE);
                        count=0;
                    }
                    else
                    {

                        count++;
                        addthequestion();

                    }

                }




            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addthequestion();
                Toast.makeText(admincreateList.this, "data add sussefully", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(admincreateList.this,newadminclass.class);
                startActivity(intent1);
            }
        });

    }

    public void addthequestion(){

        String questio1=question.getText().toString();
        String option11=option1.getText().toString();
        String option22=option2.getText().toString();
        String option33=option3.getText().toString();
        String option44=option4.getText().toString();
        String correct1=correct.getText().toString();

        questionclass questionclass=new questionclass(questio1,option11,option22,option33,option44,correct1);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(path);
        String id=databaseReference.push().getKey();
        databaseReference.child(id).setValue(questionclass);

        question.setText("");
        correct.setText("");
        option1.setText("");
        option2.setText("");
        option3.setText("");
        option4.setText("");
        questionnocount.setText("question"+count+"out of "+Integer.parseInt(howmanyquestion.getText().toString()));

    }
}