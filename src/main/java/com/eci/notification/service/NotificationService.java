package com.eci.notification.service;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;

import com.eci.notification.messaging.dto.CancelledReserveEvent;
import com.eci.notification.messaging.dto.CreatedReserveEvent;

/**
 * NotificationService is responsible for sending email notifications.
 * It uses JavaMailSender to send emails to users.
 */
@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    /**
     * Constructor for NotificationService.
     * This constructor initializes the JavaMailSender used to send emails.
     *
     * @param mailSender The JavaMailSender to be used for sending emails.
     */
    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Sends a reservation confirmation email to the user.
     *
     * @param event The CreatedReserveEvent containing reservation details.
     */
    public void sendReservationConfirmation(CreatedReserveEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getCorreoInstitucional());
        message.setSubject("Confirmación de Reserva");
        message.setText("Hola " + event.getNameUser() + ",\n\n" +
                "Tu reserva ha sido creada con éxito.\n" +
                "Detalles de la reserva:\n" +
                "Fecha: " + event.getDate() + "\n" +
                "Hora de inicio: " + event.getTimeStartBooking() + "\n" +
                "Hora de fin: " + event.getTimeEndBooking() + "\n" +
                "Nombre del salón: " + event.getHallName() + "\n" +
                "Ubicación del salón: " + event.getHallLocation() + "\n" +
                "Elementos prestados: " + String.join(", ", event.getItemsLoans()) + "\n\n" +
                "Gracias por usar nuestro servicio.");
        mailSender.send(message);
    }

    /**
     * Sends a reservation cancellation email to the user.
     *
     * @param event The CancelledReserveEvent containing reservation details.
     */
    public void sendReservationCancellation(CancelledReserveEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getCorreoInstitucional());
        message.setSubject("Cancelación de Reserva");
        message.setText("Hola " + event.getNameUser() + ",\n\n" +
                "Tu reserva ha sido cancelada.\n" +
                "Detalles de la reserva cancelada:\n" +
                "Fecha: " + event.getDate() + "\n" +
                "Hora de inicio: " + event.getTimeStartBooking() + "\n" +
                "Hora de fin: " + event.getTimeEndBooking() + "\n" +
                "Nombre del salón: " + event.getHallName() + "\n\n" +
                "Si no solicitaste esta cancelación o tienes dudas, por favor contáctanos.");
        mailSender.send(message);
    }
}
