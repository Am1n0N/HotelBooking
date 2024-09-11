package com.arabsoft.HotelBooking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.HotelBooking.dto.RoomCategoryDTO;
import com.arabsoft.HotelBooking.entity.RoomCategory;
import com.arabsoft.HotelBooking.mapper.RoomCategoryMapper;
import com.arabsoft.HotelBooking.repository.RoomCategoryRepository;
import com.arabsoft.HotelBooking.service.RoomCategoryService;

import java.util.List;


@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {
    private final RoomCategoryRepository roomCategoryRepository;
    private final RoomCategoryMapper roomCategoryMapper = RoomCategoryMapper.INSTANCE;

    public RoomCategoryServiceImpl(RoomCategoryRepository roomCategoryRepository) {
        this.roomCategoryRepository = roomCategoryRepository;
    }

    @Override
    @Transactional
    public RoomCategoryDTO createRoomCategory(RoomCategoryDTO roomCategoryDTO) {
        RoomCategory roomCategory = roomCategoryMapper.toEntity(roomCategoryDTO);
        roomCategory = roomCategoryRepository.save(roomCategory);
        return roomCategoryMapper.toDto(roomCategory);
    }

    @Override
    @Transactional
    public RoomCategoryDTO getRoomCategory(Long roomCategoryId) {
        RoomCategory roomCategory = roomCategoryRepository.findById(roomCategoryId).orElse(null);
        return roomCategoryMapper.toDto(roomCategory);
    }

    @Override
    @Transactional
    public List<RoomCategoryDTO> getAllRoomCategories() {
        List<RoomCategory> roomCategories = roomCategoryRepository.findAll();
        return roomCategoryMapper.toDtos(roomCategories);
    }

    @Override
    @Transactional
    public void updateRoomCategory(RoomCategoryDTO roomCategoryDTO) {
        RoomCategory roomCategory = roomCategoryRepository.findById(roomCategoryDTO.getRoomCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("Room category not found"));
        roomCategoryMapper.updateFromDto(roomCategoryDTO, roomCategory);
        roomCategoryRepository.save(roomCategory);
    }


}