package com.arabsoft.HotelBooking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ReservationSummaryDTO {
    private Long reservationId;
    private BookerDTO booker;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<RoomAssignmentDTO> roomAssignments;
    private BigDecimal totalPrice;
}
