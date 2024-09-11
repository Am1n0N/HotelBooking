package com.arabsoft.HotelBooking.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReservationRequestDTO {
    private Long cartId;
    private BookerDTO booker;
    private List<RoomAssignmentDTO> roomAssignments;
}
