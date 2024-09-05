package com.arabsoft.HotelBooking.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class DailyInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoomCategory roomCategory;

    private LocalDate date;

    private int availableRooms;

    private BigDecimal rate;
    
    private int temporarilyReservedRooms;

    public int getCurrentlyAvailableRooms() {
        return availableRooms - temporarilyReservedRooms;
    }
}
