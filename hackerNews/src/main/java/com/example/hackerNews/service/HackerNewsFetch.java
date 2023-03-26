package com.example.hackerNews.service;

import com.example.hackerNews.model.Comment;
import com.example.hackerNews.model.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HackerNewsFetch {
    RestTemplate restTemplate = new RestTemplate();
    Logger logger = LoggerFactory.getLogger(HackerNewsFetch.class);
    List<Story> fetchTopStories(){
        List<Story> stories = new ArrayList<>();
        logger.info("Fetching top stories from HackerNews API");
        String Uri = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
        int[] res = restTemplate.getForObject(Uri, int[].class);
        for (int i = 0; i < 10; i++) {
            String url = "https://hacker-news.firebaseio.com/v0/item/" + res[i] + ".json?print=pretty";
            Story story = restTemplate.getForObject(url, Story.class);
            stories.add(story);
        }
        return stories;
    }

    Story fetchStory(String id){
        String url = "https://hacker-news.firebaseio.com/v0/item/" + id + ".json?print=pretty";
        Story story = restTemplate.getForObject(url, Story.class);
        return story;
    }

    Comment fetchComments(int commentId){
        String url = "https://hacker-news.firebaseio.com/v0/item/" + commentId + ".json?print=pretty";
        Comment comment = restTemplate.getForObject(url, Comment.class);
        return comment;
    }
}
