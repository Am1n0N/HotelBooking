package com.arabsoft.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import com.arabsoft.HotelBooking.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByRoomCategoryId(Long roomCategoryId);

    @Query("SELECT r FROM Room r " +
           "WHERE r.roomCategory.id = :categoryId " +
           "AND r.id NOT IN " +
           "(SELECT ra.room.id FROM RoomAssignment ra " +
           "JOIN ra.reservation res " +
           "WHERE res.checkInDate < :checkOut " +
           "AND res.checkOutDate > :checkIn)")
    List<Room> findAvailableRooms(
        @Param("categoryId") Long categoryId,
        @Param("checkIn") LocalDate checkIn,
        @Param("checkOut") LocalDate checkOut
    );
}