package com.example.hackerNews.Dto;

import com.example.hackerNews.model.Comment;
import com.example.hackerNews.model.Story;
import org.springframework.stereotype.Service;

@Service
public class Transformer {
    public StoryDto transformToStoryDto(Story story){
        StoryDto storyDto=new StoryDto();

        storyDto.setTitle(story.getTitle());

        storyDto.setUrl(story.getUrl());
        storyDto.setScore(story.getScore());
        storyDto.setTimeOfSubmission(story.getTime());
        storyDto.setSubmittedBy(story.getBy());

        return storyDto;
    }
    public CommentDto transformToCommentDto(Comment comment){
        CommentDto commentDto=new CommentDto();

        commentDto.setComment(comment.getText());
        commentDto.setHackerUserId(comment.getBy());

        return commentDto;
    }

}
