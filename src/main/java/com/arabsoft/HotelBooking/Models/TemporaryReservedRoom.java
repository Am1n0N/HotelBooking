package com.arabsoft.HotelBooking.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TemporaryReservedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate date;
    private int quantity;
    private BigDecimal rateAtTimeOfReservation;

    @ManyToOne
    @JoinColumn(name = "temporary_reservation_id")
    private TemporaryReservation temporaryReservation;
}
