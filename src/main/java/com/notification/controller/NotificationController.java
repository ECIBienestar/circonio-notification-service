package com.notification.controller;

import com.notification.model.Notification;
import com.notification.service.NotificationService;
import com.notification.event.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Value("${spring.cloud.bus.id}")
    private String originService;

    @PostMapping
    public String send(@RequestBody Notification notification) {
        // null = broadcast, o puedes poner un destino específico
        String destinationService = null;

        eventPublisher.publishEvent(
            new NotificationEvent(this, originService, destinationService, notification)
        );

        return "Evento publicado en el bus para: " + notification.getRecipient();
    }
}
