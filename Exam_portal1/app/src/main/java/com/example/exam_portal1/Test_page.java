package com.example.exam_portal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Test_page extends AppCompatActivity {


    TextView questionNO,question;
    Button submit,next;

    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton option1,option2,option3,option4;


    int questioncount=0,rightAnswers=0,WrongAnswer=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);

        submit=findViewById(R.id.submit);
        next=findViewById(R.id.next);
        questionNO=findViewById(R.id.questionNo);
        radioGroup=findViewById(R.id.RadioGroup);
        question=findViewById(R.id.qestion);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);

        Toast.makeText(this, "size== "+Test_instrucation.arrayList.size(), Toast.LENGTH_SHORT).show();

        int qes=questioncount+1;
        questionNO.setText("Question "+qes +" Of  "+Test_instrucation.arrayList.size());
        question.setText("q."+Test_instrucation.arrayList.get(questioncount).getQuestion_name());
        option1.setText(""+Test_instrucation.arrayList.get(questioncount).getOption1());
        option2.setText(""+Test_instrucation.arrayList.get(questioncount).getOption2());
        option3.setText(""+Test_instrucation.arrayList.get(questioncount).getOption3());
        option4.setText(""+Test_instrucation.arrayList.get(questioncount).getOption4());


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Test_page.this, "Please select The Option", Toast.LENGTH_SHORT).show();
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
            public void onClick(View view) {

                if(radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Test_page.this, "Please select The Option", Toast.LENGTH_SHORT).show();
                }
                else {
                    CheckAnswerRightOrNot(radioButton.getText().toString());
                    Intent intent=new Intent(Test_page.this,Test_result.class);
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
        if(questioncount+1==Test_instrucation.arrayList.size())
        {
            submit.setVisibility(View.VISIBLE);
            next.setVisibility(View.GONE);
        }
//            check how many question are complete
        int qes=questioncount+1;
        questionNO.setText("Question "+qes +" Of  "+Test_instrucation.arrayList.size());

        //            update question
        question.setText("");
        question.setText(""+Test_instrucation.arrayList.get(questioncount).getQuestion_name());

        option1.setText(""+Test_instrucation.arrayList.get(questioncount).getOption1());
        option2.setText(""+Test_instrucation.arrayList.get(questioncount).getOption2());
        option3.setText(""+Test_instrucation.arrayList.get(questioncount).getOption3());
        option4.setText(""+Test_instrucation.arrayList.get(questioncount).getOption4());

    }

    public void CheckAnswerRightOrNot(String check)
    {

        if(check.equals(Test_instrucation.arrayList.get(questioncount).getCoorect()))
        {
            rightAnswers++;
        }
        else
        {
            WrongAnswer++;
        }
    }

}