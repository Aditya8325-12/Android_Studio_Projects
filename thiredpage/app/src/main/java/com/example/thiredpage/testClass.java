package com.example.thiredpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class testClass extends AppCompatActivity {

    Button submit,next;
    TextView questionNo,question;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton option1,option2,option3,option4;
    int questioncount=0;

    int rightAnswers=0;
    int WrongAnswer=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_class);

        questioncount=0;
        rightAnswers=0;
        WrongAnswer=0;


        Toast.makeText(this, "adfasd"+TestInstrucation.arrayList.size(), Toast.LENGTH_SHORT).show();
        submit=findViewById(R.id.submit);
        next=findViewById(R.id.next);
        questionNo=findViewById(R.id.questionNo);

        radioGroup=findViewById(R.id.RadioGroup);

        question=findViewById(R.id.qestion);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);


        question.setText("q."+TestInstrucation.arrayList.get(questioncount).getQuestion());
        option1.setText(""+TestInstrucation.arrayList.get(questioncount).getOption1());
        option2.setText(""+TestInstrucation.arrayList.get(questioncount).getOption1());
        option3.setText(""+TestInstrucation.arrayList.get(questioncount).getOption1());
        option4.setText(""+TestInstrucation.arrayList.get(questioncount).getOption1());


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(testClass.this, "Please select The Option", Toast.LENGTH_SHORT).show();
                }
                else {
                    int check=radioGroup.getCheckedRadioButtonId();
                    radioButton=findViewById(check);
                    CheckAnswerRightOrNot(radioButton.getText().toString());
                    questioncount++;
                    checkQuestionStatus();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(testClass.this, "Please select The Option", Toast.LENGTH_SHORT).show();
                }
                else {
                    CheckAnswerRightOrNot(radioButton.getText().toString());
                    Intent intent=new Intent(testClass.this,testresult.class);
                    intent.putExtra("correct",rightAnswers);
                    intent.putExtra("wrong",WrongAnswer);
                    startActivity(intent);
                    questioncount=0;
                    WrongAnswer=0;
                    rightAnswers=0;
                }
            }
        });

    }

    public void checkQuestionStatus()
    {


        radioGroup.clearCheck();
//            update question no

        checkQuestionNoStatus();

//            check how many question are complete

        int qes=questioncount+1;
        questionNo.setText("Question "+qes +" Of  "+TestInstrucation.arrayList.size());

//            update question
        question.setText("");
        question.setText(""+TestInstrucation.arrayList.get(questioncount).getQuestion());



        option1.setText(TestInstrucation.arrayList.get(questioncount).option1);
        option2.setText(TestInstrucation.arrayList.get(questioncount).option2);
        option3.setText(TestInstrucation.arrayList.get(questioncount).option3);
        option4.setText(TestInstrucation.arrayList.get(questioncount).option4);

    }

    public void checkQuestionNoStatus()
    {

        Toast.makeText(this, ""+questioncount+"sdf"+TestInstrucation.arrayList.size(), Toast.LENGTH_SHORT).show();
        if(questioncount+1==TestInstrucation.arrayList.size())
        {
            submit.setVisibility(View.VISIBLE);
            next.setVisibility(View.GONE);
        }
    }


    public void CheckAnswerRightOrNot(String check)
    {

        if(check.equals(TestInstrucation.arrayList.get(questioncount).getCorrect()))
        {
            rightAnswers++;
        }
        else
        {
            WrongAnswer++;
        }
    }



}