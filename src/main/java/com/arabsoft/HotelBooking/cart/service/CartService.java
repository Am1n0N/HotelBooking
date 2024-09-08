package com.arabsoft.HotelBooking.cart.service;

import java.util.Optional;

import com.arabsoft.HotelBooking.cart.model.Cart;
import com.arabsoft.HotelBooking.cart.model.CartItem;
import com.arabsoft.HotelBooking.user.model.User;


public interface CartService {
    Cart createCart(User user);
    Optional<Cart> getCartByUser(User user);
    Cart addItemToCart(Cart cart, CartItem item);
    Cart removeItemFromCart(Cart cart, CartItem item);
    void clearCart(Cart cart);
}
