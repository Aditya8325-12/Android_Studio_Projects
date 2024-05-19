package com.example.gate_exam_portal;

public class Test_info_class {

    String test_id,test_name,Test_type,Test_start_time,Test_end_time,Test_duration,test_topic,test_date;

    public Test_info_class(String test_id, String test_name,String test_type, String test_start_time, String test_end_time, String test_duration,String Test_topic,String Test_date) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.Test_start_time = test_start_time;
        this.Test_end_time = test_end_time;
        this.Test_duration = test_duration;
        this.Test_type =test_type;
        this.test_topic=Test_topic;
        this.test_date=Test_date;

    }

    public String getTest_topic() {
        return test_topic;
    }

    public String getTest_date() {
        return test_date;
    }

    public String getTest_type() {
        return Test_type;
    }

    public String getTest_id() {
        return test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public String getTest_start_time() {
        return Test_start_time;
    }

    public String getTest_end_time() {
        return Test_end_time;
    }

    public String getTest_duration() {
        return Test_duration;
    }


}
