package com.arabsoft.HotelBooking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long cartItemId;
    private Long roomCategoryId;
    private String categoryName;
    private int quantity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal price;
}
