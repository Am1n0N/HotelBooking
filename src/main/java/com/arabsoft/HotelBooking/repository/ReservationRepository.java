package com.arabsoft.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import com.arabsoft.HotelBooking.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByBookerId(Long bookerId);

    @Query("SELECT r FROM Reservation r " +
           "WHERE r.checkInDate <= :checkOutDate " +
           "AND r.checkOutDate >= :checkInDate")
    List<Reservation> findOverlappingReservations(
        @Param("checkInDate") LocalDate checkInDate,
        @Param("checkOutDate") LocalDate checkOutDate
    );
}