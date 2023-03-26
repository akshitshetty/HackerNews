package com.example.hackerNews.Dto;

public class CommentDto {
    public String getHackerUserId() {
        return hackerUserId;
    }

    public void setHackerUserId(String hackerUserId) {
        this.hackerUserId = hackerUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String hackerUserId;
    private String comment;

}
