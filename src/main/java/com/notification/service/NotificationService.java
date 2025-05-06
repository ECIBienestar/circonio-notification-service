package com.notification.service;

import com.notification.model.Notification;
import com.notification.event.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Value("${service.id}")
    private String originService;

    public String sendNotification(Notification notification) {
        String originService = "notification-service"; 
        String destinationService = null; 
    
        NotificationEvent event = new NotificationEvent(this, originService, destinationService, notification);
        eventPublisher.publishEvent(event);
    
        return "Evento de notificación publicado para: " + notification.getRecipient();
    }
    

    public String handleNotification(Notification notification) {
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
        return "SMS enviado a " + notification.getRecipient() + ": " + notification.getMessage();
    }

    private String sendPush(Notification notification) {
        return "Push enviado a " + notification.getRecipient() + ": " + notification.getMessage();
    }
}
