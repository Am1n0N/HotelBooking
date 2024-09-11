package com.arabsoft.HotelBooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.CartDTO;
import com.arabsoft.HotelBooking.dto.CartItemDTO;
import com.arabsoft.HotelBooking.entity.Cart;

import com.arabsoft.HotelBooking.entity.CartItem;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDTO toDto(Cart cart);
    CartItemDTO toDto(CartItem cartItem);
}
