package com.arabsoft.HotelBooking.room.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.arabsoft.HotelBooking.room.model.DailyInventory;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

public interface DailyInventoryService {
    DailyInventory saveDailyInventory(DailyInventory dailyInventory);
    DailyInventory updateDailyInventory(DailyInventory dailyInventory);
    void deleteDailyInventory(Long id);
    List<DailyInventory> getAllDailyInventory();
    Optional<DailyInventory> getDailyInventoryById(Long id);
    List<DailyInventory> getDailyInventoryByRoomCategory(RoomCategory roomCategory);
    List<DailyInventory> getDailyInventoryByDateRange(LocalDate startDate, LocalDate endDate);
    List<DailyInventory> getDailyInventoryByRoomCategoryAndDateRange(RoomCategory roomCategory, LocalDate startDate, LocalDate endDate);
}
