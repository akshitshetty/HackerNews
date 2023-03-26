# Hacker News API

## Overview

This is API backend is built for users to fetch top stories, past stories and comments for any story using the Hacker News API available at the [Link](https://github.com/HackerNews/API).

## Design

The Backend API is essentially a Spring boot Application which uses  Redis for caching and persisting the stories data in database.
To prevent overloading the Hacker News APIs and getting blocked from Hacker News firebase, caching has been implemented so that the users fetching data will see the same cached data.The Time-to-live for cache has been set to 15 mins.
## Items

Users can fetch Top 10 Stories, Past Stories or max 10 comments for any given story.

### Top Story-
http://localhost:8080/api/top-stories




```javascript
{
    "title": "Ruffle – Flash Emulator – Progress Report",
    "url": "https://ruffle.rs/blog/2023/03/12/progress-report.html",
    "score": 164,
    "submittedBy": "bane",
    "timeOfSubmission": 1679799593
}
```
Field | Description
------|------------
**id** | The item's unique id.
title | The title of the story, poll or job. HTML.
url | The URL of the story.
score | The story's score, or the votes for a pollopt.
submittedBy | The username of the item's author.
timeOfSubmission | Creation date of the item, in [Unix Time](http://en.wikipedia.org/wiki/Unix_time).

### Past Story-
http://localhost:8080/api/past-stories

### Comments-
http://localhost:8080/api/comments/<storyid>

    Example-http://localhost:8080/api/comments/121003

```javascript
{
  "hackerUserId": "andreyf",
  "comment": "Why not just scale the weight given to a vote based on the voter's karma? Or would this encourage group think?"
}
```
Field | Description
------|------------
**hackerUserId** | user’s hacker news handle..
comment | The comment, story or poll text. HTML.
### Delete Stories-
for deleting the past stories from Redis database.

http://localhost:8080/api/delete
## Docker

This project includes the Dockerfile for setting up the application in docker.Configure the Dockerfile and docker-compose.yml file for connecting  Spring boot app( docker container) to redis(docker container) and execute the below commands from root folder of the project.
    
    mvn clean install

    docker-compose build

    docker-compose up

## How to run locally

To run the application in your system locally follow the bellow steps-

### 1.RedisConfig.java

Add the below code snipet inside /configs/RedisConfig.java file

    @Configuration
    public class RedisConfig {
        @Bean
        JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
        }
    }

### 2. application.properties

    spring.redis.host=localhost
    spring.redis.port=6379

### 3. setup Redis in docker

excecute the below commands

    docker pull redis

    docker run --name my-redis -p 6379:6379 -d redis