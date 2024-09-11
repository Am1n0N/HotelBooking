package com.arabsoft.HotelBooking.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SearchRequestDTO {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfAdults;
    private List<Integer> kidsAges;
    private int numberOfRooms;
}
