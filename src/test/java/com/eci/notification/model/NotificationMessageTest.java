package com.eci.notification.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationMessageTest {

    @Test
    void testNoArgsConstructorAndSettersAndGetters() {
        NotificationMessage message = new NotificationMessage();
        message.setTitle("Test Title");
        message.setContent("Test Content");
        message.setType("info");

        assertEquals("Test Title", message.getTitle());
        assertEquals("Test Content", message.getContent());
        assertEquals("info", message.getType());
    }

    @Test
    void testAllArgsConstructor() {
        NotificationMessage message = new NotificationMessage("Alert", "Something happened", "warning");

        assertEquals("Alert", message.getTitle());
        assertEquals("Something happened", message.getContent());
        assertEquals("warning", message.getType());
    }
}
