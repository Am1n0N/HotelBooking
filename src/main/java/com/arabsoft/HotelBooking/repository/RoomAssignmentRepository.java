package com.arabsoft.HotelBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.entity.RoomAssignment;

@Repository
public interface RoomAssignmentRepository extends JpaRepository<RoomAssignment, Long> {
    List<RoomAssignment> findByReservationId(Long reservationId);
}