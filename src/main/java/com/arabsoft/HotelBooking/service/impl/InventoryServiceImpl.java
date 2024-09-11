package com.arabsoft.HotelBooking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.HotelBooking.dto.InventoryUpdateDTO;
import com.arabsoft.HotelBooking.entity.Inventory;
import com.arabsoft.HotelBooking.mapper.InventoryMapper;
import com.arabsoft.HotelBooking.repository.InventoryRepository;
import com.arabsoft.HotelBooking.service.InventoryService;

import java.time.LocalDate;


@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper = InventoryMapper.INSTANCE;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public void updateInventory(InventoryUpdateDTO inventoryUpdate) {
        Inventory inventory = inventoryMapper.toEntity(inventoryUpdate);
        inventoryRepository.save(inventory);
    }

    @Override
    @Transactional
    public void holdRooms(Long roomCategoryId, LocalDate checkIn, LocalDate checkOut, int quantity) {
        inventoryRepository.holdRooms(roomCategoryId, checkIn, checkOut, quantity);
    }

    @Override
    @Transactional
    public void releaseHold(Long roomCategoryId, LocalDate checkIn, LocalDate checkOut, int quantity) {
        inventoryRepository.releaseHold(roomCategoryId, checkIn, checkOut, quantity);
    }
}
