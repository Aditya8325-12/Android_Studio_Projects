package com.example.thiredpage;

public class StudentRegistration {
    String name,username,password,quailfication,depatment,college,mobile,dob,email;



    public StudentRegistration()
    {

    }

    public StudentRegistration(String name, String username, String password, String quailfication,
                               String depatment, String college, String mobile, String dob, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.quailfication = quailfication;
        this.depatment = depatment;
        this.college = college;
        this.mobile = mobile;
        this.dob = dob;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuailfication() {
        return quailfication;
    }

    public void setQuailfication(String quailfication) {
        this.quailfication = quailfication;
    }

    public String getDepatment() {
        return depatment;
    }

    public void setDepatment(String depatment) {
        this.depatment = depatment;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
