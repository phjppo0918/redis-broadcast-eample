package com.example.redisbroadcastexample.objectmessage;

import com.example.redisbroadcastexample.MessageSubscriber2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.nio.charset.StandardCharsets;

@Configuration
public class RedisObjectConfig {
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer3(RedisConnectionFactory connectionFactory, MessageObjectSubscriber messageObjectSubscriber) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageObjectSubscriber, objTopic());
        return container;
    }

    @Bean
    public RedisTemplate<String, Member> redisMemberTemplate(RedisConnectionFactory connectionFactory) {
        Jackson2JsonRedisSerializer<Member> serializer =
                new Jackson2JsonRedisSerializer<>(Member.class);
        RedisTemplate<String, Member> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        template.setDefaultSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        template.setHashValueSerializer(serializer);

        return template;
    }

    @Bean
    public ChannelTopic objTopic() {
        return new ChannelTopic("broadcast-obj-channel");
    }
}
