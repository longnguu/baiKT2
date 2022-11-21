package com.example.a2050531200222_levanlong_baikt2;

public class User {
    String Email,pass;

    public User(String email, String pass) {
        Email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
