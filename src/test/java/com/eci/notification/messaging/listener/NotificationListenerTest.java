package com.eci.notification.messaging.listener;

import com.eci.notification.messaging.dto.CreatedReserveEvent;
import com.eci.notification.service.NotificationService;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.mockito.Mockito.*;

class NotificationListenerTest {
    /**
     * Test for the createdReserveInput method in NotificationListener.
     * This test verifies that the sendReservationConfirmation method of NotificationService is called
     * when a CreatedReserveEvent is published.
     */
    @Test
    void testCreatedReserveInput() {
        NotificationService mockService = mock(NotificationService.class);
        NotificationListener listener = new NotificationListener(mockService);

        CreatedReserveEvent event = new CreatedReserveEvent();
        event.setCorreoInstitucional("test@email.com");

        Consumer<CreatedReserveEvent> consumer = listener.createdReserveInput();
        consumer.accept(event);

        verify(mockService, times(1)).sendReservationConfirmation(event);
    }
}
