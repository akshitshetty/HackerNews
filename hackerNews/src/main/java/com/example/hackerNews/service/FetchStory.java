package com.example.hackerNews.service;

import com.example.hackerNews.Dto.StoryDto;

import java.util.List;

public interface FetchStory {

    List<StoryDto> fetchTopStory();

}
