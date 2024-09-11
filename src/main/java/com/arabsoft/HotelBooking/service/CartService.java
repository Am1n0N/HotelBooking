package com.arabsoft.HotelBooking.service;

import com.arabsoft.HotelBooking.dto.CartDTO;
import com.arabsoft.HotelBooking.dto.CartItemDTO;

import java.time.LocalDate;

public interface CartService {
    CartDTO createCart();
    CartItemDTO addToCart(Long cartId, Long roomCategoryId, int quantity, LocalDate checkIn, LocalDate checkOut);
    void removeFromCart(Long cartItemId);
    CartDTO getCart(Long cartId);
    void updateCartItemQuantity(Long cartItemId, int newQuantity);
    void clearCart(Long cartId);
}
