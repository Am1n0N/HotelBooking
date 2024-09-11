package com.arabsoft.HotelBooking.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class CartDTO {
    private Long cartId;
    private List<CartItemDTO> items;
    private BigDecimal totalPrice;
}
