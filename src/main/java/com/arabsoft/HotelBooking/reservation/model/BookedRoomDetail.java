package com.arabsoft.HotelBooking.reservation.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.arabsoft.HotelBooking.room.model.Room;
import com.arabsoft.HotelBooking.user.model.Guest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class BookedRoomDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate date;
    private BigDecimal rate;

    @ManyToMany
    @JoinTable(
        name = "booked_room_guests",
        joinColumns = @JoinColumn(name = "booked_room_detail_id"),
        inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private Set<Guest> guests;
}