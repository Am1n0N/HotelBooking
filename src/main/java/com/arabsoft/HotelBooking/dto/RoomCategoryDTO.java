package com.arabsoft.HotelBooking.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoomCategoryDTO {
    private Long roomCategoryId;
    private String name;
    private int maxOccupancy;
    private List<String> amenities;
}
