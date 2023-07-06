package com.example.redisbroadcastexample.objectmessage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record Member(String name, Role role) {
}
