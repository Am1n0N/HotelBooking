package com.arabsoft.HotelBooking.room.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arabsoft.HotelBooking.room.model.DailyInventory;
import com.arabsoft.HotelBooking.room.model.RoomCategory;
import com.arabsoft.HotelBooking.room.repository.DailyInventoryRepository;

@Service
public class DailyInventoryServiceImpl implements DailyInventoryService {
    private final DailyInventoryRepository dailyInventoryRepository;

    @Autowired
    public DailyInventoryServiceImpl(DailyInventoryRepository dailyInventoryRepository) {
        this.dailyInventoryRepository = dailyInventoryRepository;
    }

    @Override
    public DailyInventory saveDailyInventory(DailyInventory dailyInventory){
        return dailyInventoryRepository.save(dailyInventory);
    }
    @Override
    public DailyInventory updateDailyInventory(DailyInventory dailyInventory){
        return dailyInventoryRepository.save(dailyInventory);
    }
    @Override
    public void deleteDailyInventory(Long id){
        dailyInventoryRepository.deleteById(id);
    }
    @Override
    public List<DailyInventory> getAllDailyInventory(){
        return dailyInventoryRepository.findAll();
    }
    @Override
    public Optional<DailyInventory> getDailyInventoryById(Long id){
        return dailyInventoryRepository.findById(id);
    }
    @Override
    public List<DailyInventory> getDailyInventoryByRoomCategory(RoomCategory roomCategory){
        return dailyInventoryRepository.findByRoomCategory(roomCategory);
    }
    @Override
    public List<DailyInventory> getDailyInventoryByDateRange(LocalDate startDate, LocalDate endDate){
        return dailyInventoryRepository.findByDateBetween(startDate, endDate);
    }
    @Override
    public List<DailyInventory> getDailyInventoryByRoomCategoryAndDateRange(RoomCategory roomCategory, LocalDate startDate, LocalDate endDate){
        return dailyInventoryRepository.findByRoomCategoryAndDateBetween(roomCategory, startDate, endDate);
    }
}
