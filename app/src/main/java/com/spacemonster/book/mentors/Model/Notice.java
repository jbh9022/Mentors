package com.spacemonster.book.mentors.Model;

public class Notice {
    private String id;
    private String notice;
    private String title;
    private String webAdd;
    private String img;
    public static final String URL = "http://jbh9022.cafe24.com/NewsView.php";
    public static final String URL2 = "http://jbh9022.cafe24.com/NewsViewAll.php";
    public Notice(String id, String notice, String title, String webAdd, String img) {
        this.id = id;
        this.notice = notice;
        this.title = title;
        this.webAdd = webAdd;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getNotice() {
        return notice;
    }

    public String getTitle() {
        return title;
    }

    public String getWebAdd() {
        return webAdd;
    }

    public String getImg() {
        return img;
    }
}
