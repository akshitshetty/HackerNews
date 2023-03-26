package com.example.hackerNews;


import com.example.hackerNews.Dto.CommentDto;
import com.example.hackerNews.Dto.StoryDto;
import com.example.hackerNews.model.Comment;
import com.example.hackerNews.model.Story;
import com.example.hackerNews.service.FetchStoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIRestController {
    @Autowired
    private FetchStoryImpl fetchStory;

    Logger logger = LoggerFactory.getLogger(APIRestController.class);
    @GetMapping("/top-stories")
    public ResponseEntity<?> getTopStories(){
        logger.info("Fetch Top Stories Api called");
        List<StoryDto> stories= fetchStory.fetchTopStory();

        return new ResponseEntity<List<StoryDto>>(stories, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/past-stories")
    public ResponseEntity<?> getPastStories(){
        logger.info("Fetch Past Stories Api called");
        List<StoryDto> stories= fetchStory.getAllStories();
        return new ResponseEntity<List<StoryDto>>(stories, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<?> getComments(@PathVariable String id){
        logger.info("Fetch Comments Api called for- "+id);
        List<CommentDto> comments= fetchStory.getComments(id);
        return new ResponseEntity<List<CommentDto>>(comments, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStory(){
        logger.info("Delete Stories Api called ");
        fetchStory.deleteAllStories();
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
