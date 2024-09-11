package com.arabsoft.HotelBooking.service;

import com.arabsoft.HotelBooking.dto.BookerDTO;

public interface BookerService {
    BookerDTO createBooker(BookerDTO bookerDTO);
    BookerDTO getBooker(Long bookerId);
    void updateBooker(BookerDTO bookerDTO);
}
