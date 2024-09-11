package com.arabsoft.HotelBooking.utils;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SearchCriteria {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfAdults;
    private List<Integer> kidsAges;
    private int numberOfRooms;
}
