package com.example.firebasedatabase;

public class student {

    public  String name;
    public  String username;

    public student()
    {

    }

    public student(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
