package com.eci.notification.messaging.service;

import com.eci.notification.messaging.dto.CreatedReserveEvent;
import com.eci.notification.service.NotificationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import static org.mockito.Mockito.*;
import java.util.List;

class NotificationServiceTest {
    @Mock
    private JavaMailSender mockMailSender;

    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        mockMailSender = mock(JavaMailSender.class);
        notificationService = new NotificationService(mockMailSender);
    }

    @Test
    void testSendReservationConfirmation() {
        // Create a sample CreatedReserveEvent
        // object with test data
        CreatedReserveEvent event = new CreatedReserveEvent();
        event.setId(1);
        event.setNameUser("John Doe");
        event.setIdUser(123);
        event.setRolUser("USER");
        event.setDate(java.time.LocalDate.now());
        event.setTimeStartBooking(java.time.LocalTime.of(10, 0));
        event.setTimeEndBooking(java.time.LocalTime.of(12, 0));
        event.setHallName("Sala CREA Juegos");
        event.setHallLocation("Edificio A segundo piso");
        event.setStatus("CONFIRMED");
        event.setItemsLoans(List.of("Tio Rico", "Ajedrez"));
        event.setCorreoInstitucional("jeimy.yaya-m@mail.escuelaing.edu.co");

        notificationService.sendReservationConfirmation(event);

        verify(mockMailSender, times(1)).send(Mockito.any(SimpleMailMessage.class));
    }
}
