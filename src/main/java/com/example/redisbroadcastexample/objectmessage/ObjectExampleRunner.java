package com.example.redisbroadcastexample.objectmessage;

import com.example.redisbroadcastexample.MessagePublisher;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ObjectExampleRunner implements CommandLineRunner {

    ObjectMessagePublisher messagePublisher;

    @Override
    public void run(String... args) throws Exception {
        messagePublisher.publish(new Member("example", Role.ADMIN));
    }
}