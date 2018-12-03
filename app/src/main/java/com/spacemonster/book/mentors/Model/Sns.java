package com.spacemonster.book.mentors.Model;

public class Sns {
    String num;
    String snsAdd;
    String snsImg;

    public Sns(String num, String snsAdd, String snsImg) {
        this.num = num;
        this.snsAdd = snsAdd;
        this.snsImg = snsImg;
    }

    public String getNum() {
        return num;
    }

    public String getSnsAdd() {
        return snsAdd;
    }

    public String getSnsImg() {
        return snsImg;
    }
}
