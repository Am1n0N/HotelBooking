package com.arabsoft.HotelBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByRoomAssignmentId(Long roomAssignmentId);
}
