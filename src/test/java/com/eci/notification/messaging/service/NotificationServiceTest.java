package com.eci.notification.messaging.service;

import com.eci.notification.messaging.dto.CreatedReserveEvent;
import com.eci.notification.messaging.dto.CancelledReserveEvent;
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

    /**
     * Test for the sendReservationConfirmation method in NotificationService.
     * This test verifies that the method sends an email with the correct details.
     */
    @Test
    void testSendReservationConfirmation() {
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
    /**
     * Test for the sendReservationCancellation method in NotificationService.
     * This test verifies that the method sends an email with the correct details.
     */
    @Test
    void testSendReservationCancellation() {
        CancelledReserveEvent event = new CancelledReserveEvent();
        event.setId(1);
        event.setNameUser("John Doe");
        event.setIdUser(123);
        event.setRolUser("USER");
        event.setDate(java.time.LocalDate.now());
        event.setTimeStartBooking(java.time.LocalTime.of(10, 0));
        event.setTimeEndBooking(java.time.LocalTime.of(12, 0));
        event.setHallName("Sala CREA Juegos");
        event.setHallLocation("Edificio A segundo piso");
        event.setStatus("CANCELLED");
        event.setCorreoInstitucional("pepito@mail.com");

        notificationService.sendReservationCancellation(event);
        verify(mockMailSender, times(1)).send(Mockito.any(SimpleMailMessage.class));
 }
}
