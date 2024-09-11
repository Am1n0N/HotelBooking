package com.arabsoft.HotelBooking.dto;


import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class SearchResultDTO {
    private Long roomCategoryId;
    private String categoryName;
    private int maxOccupancy;
    private BigDecimal price;
    private int availableRooms;
    private List<String> amenities;
}
