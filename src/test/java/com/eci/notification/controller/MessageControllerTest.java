package com.eci.notification.controller;

import com.eci.notification.model.NotificationMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageControllerTest {

    private final MessageController messageController = new MessageController();

    @Test
    public void testBroadcastMessage() {
        // Arrange
        NotificationMessage message = new NotificationMessage("Título", "Contenido", "info");

        // Act
        NotificationMessage response = messageController.broadcastMessage(message);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo("Título");
        assertThat(response.getContent()).isEqualTo("Contenido");
        assertThat(response.getType()).isEqualTo("info");
    }
}
