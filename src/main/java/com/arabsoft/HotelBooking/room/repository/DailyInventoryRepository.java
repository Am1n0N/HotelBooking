package com.arabsoft.HotelBooking.room.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.room.model.DailyInventory;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

@Repository
public interface DailyInventoryRepository extends JpaRepository<DailyInventory, Long> {
    List<DailyInventory> findByRoomCategoryAndDateBetween(RoomCategory roomCategory, LocalDate startDate, LocalDate endDate);
    Optional<DailyInventory> findByRoomCategoryAndDate(RoomCategory roomCategory, LocalDate date);
    List<DailyInventory> findByRoomCategory(RoomCategory roomCategory);
    List<DailyInventory> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
