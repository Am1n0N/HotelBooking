package com.arabsoft.HotelBooking.repository;

import com.arabsoft.HotelBooking.entity.Amenity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    List<Amenity> findByRoomCategoriesId(Long roomCategoryId);
}
