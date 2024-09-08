package com.arabsoft.HotelBooking.room.model;

import java.util.List;

import com.arabsoft.HotelBooking.reservation.model.BookedRoomDetail;

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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_category_id")
    private RoomCategory roomCategory;

    private int roomNumber;

    @OneToMany(mappedBy = "room")
    private List<BookedRoomDetail> bookings;
}
