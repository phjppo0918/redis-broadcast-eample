package com.example.redisbroadcastexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MessageSubscriber implements MessageListener {
    private static final int BUFFER_SIZE = 3; // 버퍼 크기
    private List<String> messageBuffer = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String content = new String(message.getBody());
        messageBuffer.add(content);
        if (messageBuffer.size() >= BUFFER_SIZE) {
            processMessages();
        }
        log.info("Message content: {}" , channel);
    }

    private void processMessages() {
        // 버퍼에 쌓인 메시지를 한 번에 처리
        for (String message : messageBuffer) {
            log.info("Message content: {}" , message);
        }

        // 처리 후 버퍼 초기화
        messageBuffer.clear();
    }
}