package com.arabsoft.HotelBooking.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.cart.model.Cart;
import com.arabsoft.HotelBooking.cart.model.CartItem;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);
    List<CartItem> findByRoomCategory(RoomCategory roomCategory);
    List<CartItem> findByCartAndRoomCategory(Cart cart, RoomCategory roomCategory);
}
