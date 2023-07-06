package com.example.redisbroadcastexample.objectmessage;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ObjectMessagePublisher {
    RedisTemplate<String, Member> redisTemplate;
    ChannelTopic topic = new ChannelTopic("broadcast-obj-channel");


    public void publish(Member message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
        // redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
