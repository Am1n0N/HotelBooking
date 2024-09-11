package com.arabsoft.HotelBooking.service.impl;

import org.springframework.stereotype.Service;

import com.arabsoft.HotelBooking.dto.SearchRequestDTO;
import com.arabsoft.HotelBooking.dto.SearchResultDTO;
import com.arabsoft.HotelBooking.entity.RoomCategory;
import com.arabsoft.HotelBooking.repository.InventoryRepository;
import com.arabsoft.HotelBooking.repository.RoomCategoryRepository;
import com.arabsoft.HotelBooking.service.SearchService;
import com.arabsoft.HotelBooking.mapper.SearchMapper;

import com.arabsoft.HotelBooking.utils.SearchCriteria;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    private final RoomCategoryRepository roomCategoryRepository;
    private final InventoryRepository inventoryRepository;
    private final SearchMapper searchMapper = SearchMapper.INSTANCE;

    public SearchServiceImpl(RoomCategoryRepository roomCategoryRepository, InventoryRepository inventoryRepository) {
        this.roomCategoryRepository = roomCategoryRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<SearchResultDTO> searchAvailableRooms(SearchRequestDTO searchRequest) {
        SearchCriteria criteria = searchMapper.toEntity(searchRequest);
        List<RoomCategory> availableCategories = roomCategoryRepository.findAvailableCategories(
            criteria.getCheckInDate(), criteria.getCheckOutDate(), criteria.getNumberOfRooms());
        return availableCategories.stream()
            .map(searchMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public boolean checkAvailability(Long roomCategoryId, LocalDate checkIn, LocalDate checkOut, int quantity) {
        return inventoryRepository.isAvailable(roomCategoryId, checkIn, checkOut, quantity);
    }
}