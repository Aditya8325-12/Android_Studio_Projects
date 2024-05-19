package com.example.loginpagesample;

public class StudentRegistration {


    String name,username,password,imageurl;


    public StudentRegistration()
    {

    }

    public StudentRegistration(String name, String username, String password, String imageurl) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.imageurl = imageurl;
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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}

