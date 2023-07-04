package com.example.redisbroadcastexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExampleRunner implements CommandLineRunner {

    private final MessagePublisher messagePublisher;

    public ExampleRunner(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void run(String... args) throws Exception {
        messagePublisher.publish("Hello, Redis broadcast!");
    }
}