package com.arabsoft.HotelBooking.room.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arabsoft.HotelBooking.room.model.Amenity;
import com.arabsoft.HotelBooking.room.model.RoomCategory;
import com.arabsoft.HotelBooking.room.repository.AmenityRepository;

@Service
public class AmenityServiceImpl implements AmenityService {
    private final AmenityRepository amenityRepository;

    @Autowired
    public AmenityServiceImpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @Override
    public Amenity saveAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    public List<Amenity> getAllAmenitiesByCategory(RoomCategory roomCategory) {
        return amenityRepository.findbyRoomCategory(roomCategory);
    }

    @Override
    public Optional<Amenity> getAmenityById(Long id) {
        return amenityRepository.findById(id);
    }

    @Override
    public void deleteAmenity(Long id) {
        amenityRepository.deleteById(id);
    }
}