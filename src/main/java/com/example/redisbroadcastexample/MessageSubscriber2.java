package com.example.redisbroadcastexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSubscriber2 implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String content = new String(message.getBody());
        log.info("Received message from channel: {}" , channel);
        log.info("Message content: {}" , content);

        // 수신된 메시지 처리 로직을 여기에 작성
        // ...
    }
}