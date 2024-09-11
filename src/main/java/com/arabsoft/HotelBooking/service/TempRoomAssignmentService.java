package com.arabsoft.HotelBooking.service;

import com.arabsoft.HotelBooking.dto.GuestDTO;
import com.arabsoft.HotelBooking.dto.RoomAssignmentDTO;

public interface TempRoomAssignmentService {
    RoomAssignmentDTO createTempAssignment(Long cartItemId, Long roomCategoryId, int quantity);
    void addGuestToTempAssignment(Long tempAssignmentId, GuestDTO guest);
    void removeTempAssignment(Long tempAssignmentId);
}
