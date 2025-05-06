package com.notification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationChannel {
    EMAIL,
    SMS,
    PUSH;

    @JsonCreator
    public static NotificationChannel fromString(String value) {
        for (NotificationChannel channel : NotificationChannel.values()) {
            if (channel.name().equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new IllegalArgumentException("Canal no soportado: " + value);
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}
