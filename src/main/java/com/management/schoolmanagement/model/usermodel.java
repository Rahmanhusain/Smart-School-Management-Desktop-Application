//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

public class usermodel {
    String pass;
    String User;
    String userid;
    String email;

    public usermodel(String userid, String pass, String email, String user) {
        this.User = user;
        this.pass = pass;
        this.userid = userid;
        this.email = email;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return this.User;
    }

    public void setUser(String user) {
        this.User = user;
    }
}
