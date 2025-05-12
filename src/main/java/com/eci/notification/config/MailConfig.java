package com.eci.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


/**
 * MailConfig class is responsible for configuring the JavaMailSender bean.
 * It sets up the mail server properties such as host, port, username, and password.
 */
@Configuration
public class MailConfig {

    /**
     * JavaMailSender bean configuration.
     * This method creates and configures a JavaMailSender instance.
     *
     * @return JavaMailSender
     */
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
