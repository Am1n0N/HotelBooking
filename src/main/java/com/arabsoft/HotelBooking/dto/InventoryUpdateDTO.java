package com.arabsoft.HotelBooking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class InventoryUpdateDTO {
    private Long roomCategoryId;
    private LocalDate date;
    private int availableRooms;
    private BigDecimal rate;
}
