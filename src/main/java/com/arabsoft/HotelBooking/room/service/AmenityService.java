package com.arabsoft.HotelBooking.room.service;

import java.util.List;
import java.util.Optional;

import com.arabsoft.HotelBooking.room.model.Amenity;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

public interface AmenityService {
    Amenity saveAmenity(Amenity amenity);
    List<Amenity> getAllAmenitiesByCategory(RoomCategory roomCategory);
    Optional<Amenity> getAmenityById(Long id);
    void deleteAmenity(Long id);
}
