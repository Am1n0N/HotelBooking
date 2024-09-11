package com.arabsoft.HotelBooking.service;

import java.util.List;

import com.arabsoft.HotelBooking.dto.ReservationRequestDTO;
import com.arabsoft.HotelBooking.dto.ReservationSummaryDTO;


public interface ReservationService {
    ReservationSummaryDTO createReservation(ReservationRequestDTO reservationRequest);
    ReservationSummaryDTO getReservationSummary(Long reservationId);
    List<ReservationSummaryDTO> getBookerReservations(Long bookerId);
    void cancelReservation(Long reservationId);
}
