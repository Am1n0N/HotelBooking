package com.arabsoft.HotelBooking.exception;

public class RoomCategoryNotFoundException extends RuntimeException {
    public RoomCategoryNotFoundException(String message) {
        super(message);
    }
}
