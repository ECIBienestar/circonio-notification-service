package com.eci.notification.messaging.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eci.notification.messaging.dto.CreatedReserveEvent;
import com.eci.notification.service.NotificationService;

import java.util.function.Consumer;


@Configuration
public class NotificationListener {

    private final NotificationService notificationService;

    public NotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Listener for CreatedReserveEvent.
     * This method will be triggered when a CreatedReserveEvent is published.
     * It will send a reservation confirmation email using the NotificationService.
     *
     * @return Consumer<CreatedReserveEvent>
     */
    @Bean
    public Consumer<CreatedReserveEvent> createdReserveInput() {
        return notificationService::sendReservationConfirmation;
    }
}