package com.arabsoft.HotelBooking.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.arabsoft.HotelBooking.Enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;



@Data
@Entity
public class Booking {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booker_id")
    private User booker;

    private LocalDate creationDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @OneToMany(mappedBy = "booking")
    private List<BookedRoomDetail> bookedRoomDetails;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @OneToOne
    @JoinColumn(name = "temporary_reservation_id")
    private TemporaryReservation temporaryReservation;
   
}
