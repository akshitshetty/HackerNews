package com.example.hackerNews.repository;

import com.example.hackerNews.model.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<Story, String> {
}
