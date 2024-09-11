package com.arabsoft.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.entity.Inventory;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Inventory i " +
           "WHERE i.roomCategory.id = :categoryId " +
           "AND i.date BETWEEN :checkIn AND :checkOut " +
           "AND i.availableRooms >= :quantity")
    boolean isAvailable(
        @Param("categoryId") Long categoryId,
        @Param("checkIn") LocalDate checkIn,
        @Param("checkOut") LocalDate checkOut,
        @Param("quantity") int quantity
    );

    @Query("UPDATE Inventory i SET i.availableRooms = i.availableRooms - :quantity " +
           "WHERE i.roomCategory.id = :categoryId " +
           "AND i.date BETWEEN :checkIn AND :checkOut")
    void holdRooms(
        @Param("categoryId") Long categoryId,
        @Param("checkIn") LocalDate checkIn,
        @Param("checkOut") LocalDate checkOut,
        @Param("quantity") int quantity
    );

    @Query("UPDATE Inventory i SET i.availableRooms = i.availableRooms + :quantity " +
           "WHERE i.roomCategory.id = :categoryId " +
           "AND i.date BETWEEN :checkIn AND :checkOut")
    void releaseHold(
        @Param("categoryId") Long categoryId,
        @Param("checkIn") LocalDate checkIn,
        @Param("checkOut") LocalDate checkOut,
        @Param("quantity") int quantity
    );
}
