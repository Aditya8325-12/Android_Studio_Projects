package com.example.mysqlexample2;

public class CreateAccount {

    int UName;
    int PWord;
    String Email;

    public  CreateAccount(int i)
    {

    }


    public CreateAccount(int UName, int PWord, String email) {
        this.UName = UName;
        this.PWord = PWord;
        this.Email = email;
    }

    public int getUName() {
        return UName;
    }

    public void setUName(int UName) {
        this.UName = UName;
    }

    public int getPWord() {
        return PWord;
    }

    public void setPWord(int PWord) {
        this.PWord = PWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
