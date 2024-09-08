package com.arabsoft.HotelBooking.reservation.model;

import java.time.LocalDateTime;
import java.util.List;

import com.arabsoft.HotelBooking.Enums.ReservationStatus;
import com.arabsoft.HotelBooking.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class TemporaryReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;

    @OneToMany(mappedBy = "temporaryReservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemporaryReservedRoom> reservedRooms;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}

