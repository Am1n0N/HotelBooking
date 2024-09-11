package com.arabsoft.HotelBooking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.HotelBooking.dto.CartDTO;
import com.arabsoft.HotelBooking.dto.CartItemDTO;
import com.arabsoft.HotelBooking.entity.Cart;
import com.arabsoft.HotelBooking.entity.CartItem;
import com.arabsoft.HotelBooking.entity.Inventory;
import com.arabsoft.HotelBooking.entity.RoomCategory;
import com.arabsoft.HotelBooking.exception.CartNotFoundException;
import com.arabsoft.HotelBooking.mapper.CartMapper;
import com.arabsoft.HotelBooking.repository.CartItemRepository;
import com.arabsoft.HotelBooking.repository.CartRepository;
import com.arabsoft.HotelBooking.repository.RoomCategoryRepository;
import com.arabsoft.HotelBooking.exception.RoomCategoryNotFoundException;
import com.arabsoft.HotelBooking.service.InventoryService;
import com.arabsoft.HotelBooking.service.CartService;

import java.time.LocalDateTime;

import java.time.LocalDate;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final InventoryService inventoryService;
    private final RoomCategoryRepository roomCategoryRepository;
    private final CartMapper cartMapper = CartMapper.INSTANCE;

    public CartServiceImpl(CartRepository cartRepository, 
    CartItemRepository cartItemRepository, 
    RoomCategoryRepository roomCategoryRepository,
    InventoryService inventoryService
    ) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.roomCategoryRepository = roomCategoryRepository;
        this.inventoryService = inventoryService;
    }

    @Override
    @Transactional
    public CartDTO createCart() {
        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    @Override
    @Transactional
    public CartItemDTO addToCart(Long cartId, Long roomCategoryId, int quantity, LocalDate checkIn, LocalDate checkOut) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setRoomCategory(roomCategoryRepository.findById(roomCategoryId)
            .orElseThrow(() -> new RoomCategoryNotFoundException("Room category not found")));
        cartItem.setQuantity(quantity);
        cartItem.setCheckInDate(checkIn);
        cartItem.setCheckOutDate(checkOut);
        inventoryService.holdRooms(roomCategoryId, checkIn, checkOut, quantity);

        cartItem.setExpirationTime(LocalDateTime.now().plusMinutes(30));
        cartItem = cartItemRepository.save(cartItem);
        return cartMapper.toDto(cartItem);
    }


    @Override
    @Transactional
    public void removeFromCart(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
            .orElseThrow(() -> new CartNotFoundException("Cart item not found"));
        
        inventoryService.releaseHold(cartItem.getRoomCategory().getId(), cartItem.getCheckInDate(), cartItem.getCheckOutDate(), cartItem.getQuantity());    
        cartItemRepository.delete(cartItem);

    }

    @Override
    @Transactional
    public void clearCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        
        for (CartItem cartItem : cart.getItems()) {
            inventoryService.releaseHold(cartItem.getRoomCategory().getId(), cartItem.getCheckInDate(), cartItem.getCheckOutDate(), cartItem.getQuantity());
            cartItemRepository.delete(cartItem);
        }
    }

    @Override
    @Transactional
    public void updateCartItemQuantity(Long cartItemId, int newQuantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
            .orElseThrow(() -> new CartNotFoundException("Cart item not found"));
        inventoryService.releaseHold(cartItem.getRoomCategory().getId(), cartItem.getCheckInDate(), cartItem.getCheckOutDate(), cartItem.getQuantity());
        cartItem.setQuantity(newQuantity);
        cartItemRepository.save(cartItem);
        inventoryService.holdRooms(cartItem.getRoomCategory().getId(), cartItem.getCheckInDate(), cartItem.getCheckOutDate(), newQuantity);
    }

    @Override
    @Transactional
    public CartDTO getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        return cartMapper.toDto(cart);
    }
}
