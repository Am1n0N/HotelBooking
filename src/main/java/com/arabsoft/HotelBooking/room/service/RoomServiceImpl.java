package com.arabsoft.HotelBooking.room.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arabsoft.HotelBooking.room.model.DailyInventory;
import com.arabsoft.HotelBooking.room.model.Room;
import com.arabsoft.HotelBooking.room.model.RoomCategory;
import com.arabsoft.HotelBooking.room.repository.DailyInventoryRepository;
import com.arabsoft.HotelBooking.room.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, DailyInventoryRepository dailyInventoryRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Room> getRoomsByCategory(RoomCategory category) {
        return roomRepository.findByRoomCategory(category);
    }

    @Override
    public List<Room> getAvailableRoomsByCategoryAndDateRange(RoomCategory category, LocalDate checkInDate, LocalDate checkOutDate) {
         return roomRepository.findAvailableRoomsByCategoryAndDateRange(category, checkInDate, checkOutDate);
    }
}
