package com.eci.notification.controller;

import com.eci.notification.model.NotificationMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageControllerUnitTest {

    private final MessageController controller = new MessageController();

    @Test
    public void testBroadcastMessageReturnsSameMessage() {
        NotificationMessage input = new NotificationMessage("Title", "This is a message", "info");

        NotificationMessage result = controller.broadcastMessage(input);

        assertNotNull(result);
        assertEquals("Title", result.getTitle());
        assertEquals("This is a message", result.getContent());
        assertEquals("info", result.getType());
        assertSame(input, result);
    }

    @Test
    public void testBroadcastMessageWithEmptyFields() {
        NotificationMessage empty = new NotificationMessage("", "", "");

        NotificationMessage result = controller.broadcastMessage(empty);

        assertNotNull(result);
        assertEquals("", result.getTitle());
        assertEquals("", result.getContent());
        assertEquals("", result.getType());
    }

    @Test
    public void testBroadcastMessageWithNullMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.broadcastMessage(null);
        });
        assertEquals("Message cannot be null", exception.getMessage());
    }

    @Test
    public void testBroadcastMessageWithNullFields() {
        NotificationMessage messageWithNullFields = new NotificationMessage(null, "Content", "info");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.broadcastMessage(messageWithNullFields);
        });
        assertEquals("Message fields cannot be null", exception.getMessage());
    }

    @Test
    public void testBroadcastMessageWithAllFieldsNull() {
        NotificationMessage messageWithAllNulls = new NotificationMessage(null, null, null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.broadcastMessage(messageWithAllNulls);
        });
        assertEquals("Message fields cannot be null", exception.getMessage());
    }
}
