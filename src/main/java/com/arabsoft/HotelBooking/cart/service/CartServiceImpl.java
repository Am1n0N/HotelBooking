package com.arabsoft.HotelBooking.cart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arabsoft.HotelBooking.cart.model.Cart;
import com.arabsoft.HotelBooking.cart.model.CartItem;
import com.arabsoft.HotelBooking.cart.repository.CartItemRepository;
import com.arabsoft.HotelBooking.cart.repository.CartRepository;
import com.arabsoft.HotelBooking.user.model.User;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    @Override
    public Cart addItemToCart(Cart cart, CartItem item) {
        item.setCart(cart);
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItemFromCart(Cart cart, CartItem item) {
        cart.getItems().remove(item);
        cartItemRepository.delete(item);
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Cart cart) {
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
