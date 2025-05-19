package com.eci.notification.controller;

import com.eci.notification.model.NotificationMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/send") 
    @SendTo("/topic/messages") 
    public NotificationMessage broadcastMessage(NotificationMessage message) {
        return message;
    }
}
