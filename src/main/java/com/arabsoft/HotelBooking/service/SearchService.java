package com.arabsoft.HotelBooking.service;

import java.time.LocalDate;
import java.util.List;

import com.arabsoft.HotelBooking.dto.SearchRequestDTO;
import com.arabsoft.HotelBooking.dto.SearchResultDTO;

public interface SearchService {
    List<SearchResultDTO> searchAvailableRooms(SearchRequestDTO searchRequest);
    boolean checkAvailability(Long roomCategoryId, LocalDate checkIn, LocalDate checkOut, int quantity);
}
