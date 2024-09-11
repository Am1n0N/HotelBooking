package com.arabsoft.HotelBooking.service;

import com.arabsoft.HotelBooking.dto.InventoryUpdateDTO;

import java.time.LocalDate;

public interface InventoryService {
    void updateInventory(InventoryUpdateDTO inventoryUpdate);
    void holdRooms(Long roomCategoryId, LocalDate checkIn, LocalDate checkOut, int quantity);
    void releaseHold(Long roomCategoryId, LocalDate checkIn, LocalDate checkOut, int quantity);
}
