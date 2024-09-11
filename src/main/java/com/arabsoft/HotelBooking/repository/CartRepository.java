package com.arabsoft.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
