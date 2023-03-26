package com.example.hackerNews.service;

import com.example.hackerNews.APIRestController;
import com.example.hackerNews.Dto.CommentDto;
import com.example.hackerNews.Dto.StoryDto;
import com.example.hackerNews.Dto.Transformer;
import com.example.hackerNews.model.Comment;
import com.example.hackerNews.model.Story;
import com.example.hackerNews.model.StoryCached;
import com.example.hackerNews.repository.CachedTopStoriesRepository;
import com.example.hackerNews.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FetchStoryImpl implements FetchStory {
    private final String CACHE_ID = "cached_top_story";
    @Autowired
    HackerNewsFetch hackerNewsFetch;
    @Autowired
    StoryRepository storyRepository;
    @Autowired
    CachedTopStoriesRepository cachedRepo;

    @Autowired
    Transformer transformer;
    Logger logger = LoggerFactory.getLogger(FetchStoryImpl.class);

    public List<StoryDto> getAllStories() {
        List<Story> stories = new ArrayList<>();
        logger.info("Fetching all past stories");
        storyRepository.findAll().iterator().forEachRemaining(stories::add);
        return stories.stream().map(story -> transformer.transformToStoryDto(story)).toList();
    }
    public void deleteAllStories() {
        storyRepository.deleteAll();
        logger.info("Deleted all past stories");
    }

    public List<StoryDto> fetchTopStory() {

        Optional<StoryCached> storyCached= cachedRepo.findById(CACHE_ID) ;
        if (storyCached.isPresent()) {
            logger.info("Fetching top stories from cache");
            return storyCached.get().getStories().stream().map(story -> transformer.transformToStoryDto(story)).toList();
        }
        List<Story> stories = hackerNewsFetch.fetchTopStories();

        storyRepository.saveAll(stories);
        cachedRepo.save(new StoryCached(stories, CACHE_ID));
        return stories.stream().map(story -> transformer.transformToStoryDto(story)).toList();
    }

    public List<CommentDto> getComments(String id) {
        Story story = hackerNewsFetch.fetchStory(id);
        List<Integer> commentIds = story.getKids();
        if(commentIds!=null){
            List<Comment> comments = new ArrayList<>();
            for (int commentId : commentIds) {
                Comment comment = hackerNewsFetch.fetchComments(commentId);
                comments.add(comment);
            }
            Collections.sort(comments, (a, b) -> b.getKids().size() - a.getKids().size());
            if(comments.size()<10)
                return comments.stream().map(comment -> transformer.transformToCommentDto(comment)).toList();
            else
                return comments.subList(0, 9).stream().map(comment -> transformer.transformToCommentDto(comment)).toList();
        }
        logger.info("No Comments found for story- "+id);
        return Collections.EMPTY_LIST;
    }

}
