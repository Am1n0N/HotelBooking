package com.arabsoft.HotelBooking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "room_category_id")
    private RoomCategory roomCategory;
    
    private int quantity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private LocalDateTime expirationTime;

    @OneToMany(mappedBy = "tempReservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TempRoomAssignment> tempRoomAssignments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}