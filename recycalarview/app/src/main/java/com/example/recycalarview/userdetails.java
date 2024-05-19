package com.example.recycalarview;

public class userdetails {

    int image;
    String name,username;

    public userdetails(int image, String name, String username) {
        this.image = image;
        this.name = name;
        this.username = username;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
