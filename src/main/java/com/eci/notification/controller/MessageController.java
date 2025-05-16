package com.eci.notification.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/send") // cliente envía a /app/send
    @SendTo("/topic/messages") // se retransmite a los subscriptores
    public String broadcastMessage(String message) {
        return message; // Aquí podrías mapear a un objeto si lo deseas
    }
}
