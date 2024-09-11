package com.arabsoft.HotelBooking.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoomAssignmentDTO {
    private Long roomAssignmentId;
    private String roomNumber;
    private String categoryName;
    private List<GuestDTO> guests;
}
