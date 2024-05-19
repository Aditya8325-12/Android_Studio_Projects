package com.example.gate_exam_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class user_test_record_page extends AppCompatActivity {

    TextView t_question,correct,t_marks,ts_name,ts_type,user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_test_record_page);
        t_question=findViewById(R.id.total_question);
        correct=findViewById(R.id.correct);
        t_marks=findViewById(R.id.total_marks);
        ts_name=findViewById(R.id.test_name);
        ts_type=findViewById(R.id.test_type);
        user_id=findViewById(R.id.user_id);

        Intent intent=getIntent();
        int postion=intent.getIntExtra("postion",0);

        t_question.setText("Total Question ="+MyProgress.save_data.get(postion).Total_question);
        correct.setText("Correct Answer = "+MyProgress.save_data.get(postion).marks_obtain);
        t_marks.setText("Total marks ="+MyProgress.save_data.get(postion).Total_question);
        ts_name.setText("Test_name="+ Test_list.testInfo.get(postion).test_name);
        ts_type.setText("Test_type="+Test_list.testInfo.get(postion).Test_type);
        user_id.setText("user_id="+ Home_page.user_id);


    }
}