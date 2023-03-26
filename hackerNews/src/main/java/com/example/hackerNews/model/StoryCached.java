package com.example.hackerNews.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash(timeToLive = 900L, value = "CachedTopStory")
public class StoryCached {

    @Id
    private String id;
    private List<Story> stories;

    public StoryCached(List<Story> stories, String id) {
        this.stories = stories;
        this.id = id;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
