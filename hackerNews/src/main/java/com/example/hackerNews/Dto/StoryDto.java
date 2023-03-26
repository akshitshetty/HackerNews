package com.example.hackerNews.Dto;

public class StoryDto {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public long getTimeOfSubmission() {
        return timeOfSubmission;
    }

    public void setTimeOfSubmission(long timeOfSubmission) {
        this.timeOfSubmission = timeOfSubmission;
    }

    private String title;
    private String url;
    private int score;
    private String submittedBy;
    private long timeOfSubmission;
}
