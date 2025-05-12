package com.eci.notification.service;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import com.eci.notification.messaging.dto.CreatedReserveEvent;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

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
}
