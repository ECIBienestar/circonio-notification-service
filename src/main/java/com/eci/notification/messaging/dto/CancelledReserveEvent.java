package com.eci.notification.messaging.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Data Transfer Object (DTO) representing the event triggered when a reservation is cancelled.
 * This object is sent through the message broker and consumed by the notification service
 * to generate and send appropriate notifications (e.g., emails).
 */
public class CancelledReserveEvent {

    private int id; // ID de la reserva
    private String nameUser;
    private int idUser;
    private String rolUser;
    private LocalDate date;
    private LocalTime timeStartBooking;
    private LocalTime timeEndBooking;
    private String hallName;    
    private String hallLocation;  
    private String status;
    private String correoInstitucional; 

}
