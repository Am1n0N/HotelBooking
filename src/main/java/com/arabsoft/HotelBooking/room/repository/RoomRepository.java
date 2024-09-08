package com.arabsoft.HotelBooking.room.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.room.model.Room;
import com.arabsoft.HotelBooking.room.model.RoomCategory;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByRoomCategory(RoomCategory roomCategory);
    Optional<Room> findByRoomNumber(int roomNumber);
        @Query("SELECT DISTINCT availableRoom FROM Room availableRoom " +
        "JOIN availableRoom.roomCategory roomCat " +
        "WHERE roomCat = :requestedCategory " +
        "AND availableRoom NOT IN (" +
        "    SELECT bookedRoom.room FROM BookedRoomDetail bookedRoom " +
        "    JOIN bookedRoom.booking existingBooking " +
        "    WHERE existingBooking.checkInDate <= :requestedEndDate AND existingBooking.checkOutDate >= :requestedStartDate" +
        ") " +
        "AND availableRoom NOT IN (" +
        "    SELECT tempReservedRoom.room FROM TemporaryReservedRoom tempReservedRoom " +
        "    JOIN tempReservedRoom.temporaryReservation tempReservation " +
        "    WHERE tempReservation.creationTime <= :requestedEndDate AND tempReservation.expirationTime >= :requestedStartDate" +
        ")")
    List<Room> findAvailableRoomsByCategoryAndDateRange(
        @Param("requestedCategory") RoomCategory requestedCategory,
        @Param("requestedStartDate") LocalDate requestedStartDate,
        @Param("requestedEndDate") LocalDate requestedEndDate);
}