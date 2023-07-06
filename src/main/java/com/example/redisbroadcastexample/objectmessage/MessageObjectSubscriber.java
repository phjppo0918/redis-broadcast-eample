package com.example.redisbroadcastexample.objectmessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageObjectSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        Jackson2JsonRedisSerializer<Member> serializer =
                new Jackson2JsonRedisSerializer<>(Member.class);
        final Member member = serializer.deserialize(message.getBody());
        log.info("Received message from channel: {}", channel);
        log.info("Message content: {}", member.name());
        log.info("Message content: {}", member.role());

        // 수신된 메시지 처리 로직을 여기에 작성
        // ...
    }
}