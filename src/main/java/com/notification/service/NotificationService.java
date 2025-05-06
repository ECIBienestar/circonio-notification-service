package com.notification.service;

import com.notification.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendNotification(Notification notification) {
        switch (notification.getChannel()) {
            case EMAIL:
                return sendEmail(notification);
            case SMS:
                return sendSMS(notification);
            case PUSH:
                return sendPush(notification);
            default:
                throw new IllegalArgumentException("Canal no soportado: " + notification.getChannel());
        }
    }

    private String sendEmail(Notification notification) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setTo(notification.getRecipient());
            helper.setSubject("Notificación del sistema");
            helper.setText(notification.getMessage(), true); // true = HTML

            mailSender.send(mimeMessage);
            return "Correo enviado a " + notification.getRecipient() + ": " + notification.getMessage();

        } catch (MessagingException | MailException e) {
            return "Error al enviar correo a " + notification.getRecipient() + ": " + e.getMessage();
        }
    }

    private String sendSMS(Notification notification) {
        // Simulación del envío de SMS
        return "SMS enviado a " + notification.getRecipient() + ": " + notification.getMessage();
    }

    private String sendPush(Notification notification) {
        // Simulación de notificación push
        return "Push enviado a " + notification.getRecipient() + ": " + notification.getMessage();
    }
}
