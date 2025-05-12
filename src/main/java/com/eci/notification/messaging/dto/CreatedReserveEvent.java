package com.eci.notification.messaging.dto;

import lombok.*;  

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CreatedReserveEvent {
    private int id; // ID de la reserva
    private String nameUser;
    private int idUser;
    private String rolUser;
    private LocalDate date;
    private LocalTime timeStartBooking;
    private LocalTime timeEndBooking;
    private String hallName;      // Extraído de HallEntity
    private String hallLocation;  // Extraído de HallEntity
    private String status;
    private List<String> itemsLoans; // Nombres de los elementos prestados
    private String correoInstitucional; // Para enviar la notificación

}


