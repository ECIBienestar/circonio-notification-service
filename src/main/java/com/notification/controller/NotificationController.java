package com.notification.controller;

import com.notification.model.Notification;
import com.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public String send(@RequestBody Notification notification) {
        return service.sendNotification(notification);
    }
}