package com.arabsoft.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arabsoft.HotelBooking.entity.Booker;

import java.util.Optional;

@Repository
public interface BookerRepository extends JpaRepository<Booker, Long> {
    Optional<Booker> findByEmail(String email);
}
