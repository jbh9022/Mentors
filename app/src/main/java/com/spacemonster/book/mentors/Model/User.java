package com.spacemonster.book.mentors.Model;

public class User {
    String userCheck;
    String userName;

    public User(String userCheck, String userName) {
        this.userCheck = userCheck;
        this.userName = userName;
    }

    public String getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(String userCheck) {
        this.userCheck = userCheck;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
