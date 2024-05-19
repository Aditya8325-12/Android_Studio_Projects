package com.example.exam_portal1;

public class Test_question {

    public String question_name,option1,option2,option3,option4,coorect;


    Test_question(String q,String o1,String o2,String o3,String o4,String c)
    {
        this.question_name=q;
        this.option1=o1;
        this.option2=o2;
        this.option3=o3;
        this.option4=o4;
        this.coorect=c;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getCoorect() {
        return coorect;
    }
}
