package com.eci.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
/**
 * Javamailsender configuration to send emails.
 * This class sets Javamailsender Bean that will be used to send emails.
 */
public class MailConfig {
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); 
        mailSender.setPort(587); 
        mailSender.setUsername("jeimy.yaya-m@mail.esscuelaing.edu.co"); 
        mailSender.setPassword(System.getenv("MAIL_PASSWORD")); 
        return mailSender;
    }
}
