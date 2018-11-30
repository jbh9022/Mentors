package com.spacemonster.book.mentors.Model;

public class Sns {
    String id;
    String snsAdd;
    String snsImg;

    public Sns(String id, String snsAdd, String snsImg) {
        this.id = id;
        this.snsAdd = snsAdd;
        this.snsImg = snsImg;
    }

    public String getId() {
        return id;
    }

    public String getSnsAdd() {
        return snsAdd;
    }

    public String getSnsImg() {
        return snsImg;
    }
}
