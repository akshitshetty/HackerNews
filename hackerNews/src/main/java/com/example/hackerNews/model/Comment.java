package com.example.hackerNews.model;

import java.util.Collections;
import java.util.List;

public class Comment {
    private int id;

    private List<Integer> kids;

    private String by;
    private String text;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getKids() {
        return kids == null ? Collections.emptyList() : kids;
    }

    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
