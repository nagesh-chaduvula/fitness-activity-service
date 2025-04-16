package com.fitness.activityservice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum ActivityType {
    WALKING("W"),
    RUNNING("R"),
    CYCLING("C"),
    SWIMMING("S"),
    HIKING("H"),
    YOGA("Y"),
    GYM("G"),
    OTHER("Z");

    @JsonValue
    private final String activityType;

    @JsonCreator
    public static ActivityType decode(String activityType) {
        return Stream.of(ActivityType.values())
                .filter(targetEnum -> Objects.equals(targetEnum.activityType, activityType))
                .findFirst()
                .orElse(ActivityType.OTHER);
    }

}
