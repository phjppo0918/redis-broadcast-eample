package com.example.redisbroadcastexample;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final RedisTemplate<String, String> redisTemplate;
    private final ChannelTopic topic;

    public MessagePublisher(RedisTemplate<String, String> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
        redisTemplate.convertAndSend(topic.getTopic(), message);
       // redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}