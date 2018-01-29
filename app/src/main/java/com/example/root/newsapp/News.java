package com.example.root.newsapp;

/**
 * Created by root on 5/1/18.
 */

class News {
    private String title;
    private String author;
    private String url;
    private String date;
    private String section;

    News (String t, String a, String u, String d, String s) {
        title = t;
        author = a;
        url = u;
        date = d;
        section = s;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getUrl() {
        return url;
    }

    String getDate() {
        return date;
    }

    String getSection() {
        return section;
    }

}
