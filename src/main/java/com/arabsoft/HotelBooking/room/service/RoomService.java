package com.arabsoft.HotelBooking.room.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.arabsoft.HotelBooking.room.model.Room;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

public interface RoomService {
    Room saveRoom(Room room);
    Optional<Room> getRoomById(Long id);
    List<Room> getRoomsByCategory(RoomCategory category);
    List<Room> getAvailableRoomsByCategoryAndDateRange(RoomCategory category, LocalDate checkInDate, LocalDate checkOutDate);
}
