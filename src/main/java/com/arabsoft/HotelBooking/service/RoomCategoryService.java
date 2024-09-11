package com.arabsoft.HotelBooking.service;

import java.util.List;

import com.arabsoft.HotelBooking.dto.RoomCategoryDTO;

public interface RoomCategoryService {
    RoomCategoryDTO createRoomCategory(RoomCategoryDTO roomCategoryDTO);
    RoomCategoryDTO getRoomCategory(Long roomCategoryId);
    List<RoomCategoryDTO> getAllRoomCategories();
    void updateRoomCategory(RoomCategoryDTO roomCategoryDTO);
}
