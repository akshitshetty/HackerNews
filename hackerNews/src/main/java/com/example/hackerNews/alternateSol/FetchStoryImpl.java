package com.example.hackerNews.alternateSol;//package com.example.demo;
//
//import com.example.demo.model.Story;
//import com.example.demo.service.FetchStory;
//import com.example.demo.service.HackerNewsFetch;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//public class FetchStoryImpl implements FetchStory {
//    @Autowired
//    HackerNewsFetch hackerNewsFetch;
//    public List<Story> fetchTopStory(){
//        if(Cache.isValid()){
//            return Cache.getStory();
//        }else {
//            List<Story> stories=hackerNewsFetch.fetchTopStories();
//            Cache.reset(stories);
//            return stories;
//        }
//    }
//}
