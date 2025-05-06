package com.notification;

import com.notification.model.NotificationChannel;
import com.notification.model.Notification;
import com.notification.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;



@SpringBootTest
class NotificationServiceTest {

    @Autowired
    private NotificationService service;

    @Test
    void sendNotification_returnsExpectedMessage() {
        Notification notification = new Notification("juan@escuelaing.edu.co", "Hola Juan", NotificationChannel.EMAIL);
        String response = service.sendNotification(notification);

        assertTrue(response.contains("Correo enviado"));
        assertTrue(response.contains("juan@escuelaing.edu.co"));
        assertTrue(response.contains("Hola Juan"));
    }
}