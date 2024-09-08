package com.arabsoft.HotelBooking.room.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.room.model.Room;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {
    Optional<RoomCategory> findByName(String name);
    Optional<RoomCategory> findbyRoom(Room room);
}