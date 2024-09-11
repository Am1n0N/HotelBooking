package com.arabsoft.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.entity.RoomCategory;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {
    @Query("SELECT rc FROM RoomCategory rc WHERE rc.id IN " +
           "(SELECT DISTINCT i.roomCategory.id FROM Inventory i " +
           "WHERE i.date BETWEEN :checkIn AND :checkOut " +
           "GROUP BY i.roomCategory.id " +
           "HAVING MIN(i.availableRooms) >= :numberOfRooms)")
    List<RoomCategory> findAvailableCategories(
        @Param("checkIn") LocalDate checkIn,
        @Param("checkOut") LocalDate checkOut,
        @Param("numberOfRooms") int numberOfRooms
    );
}