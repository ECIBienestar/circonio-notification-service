package com.eci.notification.messaging.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eci.notification.messaging.dto.CreatedReserveEvent;
import com.eci.notification.messaging.dto.CancelledReserveEvent;
import com.eci.notification.service.NotificationService;

import java.util.function.Consumer;


/**
 * NotificationListener class listens for events related to notifications.
 * It uses the NotificationService to handle the events.
 */
@Configuration
public class NotificationListener {

    private final NotificationService notificationService;

    /**
     * Constructor for NotificationListener.
     * This constructor initializes the NotificationService.
     *
     * @param notificationService the NotificationService to be used
     */
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

    /**
     * Listener for CancelledReserveEvent.
     * This method will be triggered when a CancelledReserveEvent is published.
     * It will send a reservation cancellation email using the NotificationService.
     *
     * @return Consumer<CancelledReserveEvent>
     */
    @Bean
    public Consumer<CancelledReserveEvent> cancelledReserveInput() {
        return notificationService::sendReservationCancellation;
    }
}