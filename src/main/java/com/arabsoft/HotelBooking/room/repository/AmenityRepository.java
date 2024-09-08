package com.arabsoft.HotelBooking.room.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.room.model.Amenity;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    List<Amenity> findbyRoomCategory(RoomCategory roomCategory);
}
