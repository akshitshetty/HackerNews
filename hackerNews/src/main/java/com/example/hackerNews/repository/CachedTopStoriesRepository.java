package com.example.hackerNews.repository;

import com.example.hackerNews.model.StoryCached;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachedTopStoriesRepository extends CrudRepository<StoryCached, String> {
}
