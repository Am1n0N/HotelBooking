package com.arabsoft.HotelBooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.HotelBooking.dto.ReservationRequestDTO;
import com.arabsoft.HotelBooking.dto.ReservationSummaryDTO;
import com.arabsoft.HotelBooking.entity.Reservation;
import com.arabsoft.HotelBooking.entity.Room;
import com.arabsoft.HotelBooking.entity.RoomAssignment;
import com.arabsoft.HotelBooking.exception.ReservationNotFoundException;

import com.arabsoft.HotelBooking.mapper.ReservationMapper;
import com.arabsoft.HotelBooking.repository.ReservationRepository;
import com.arabsoft.HotelBooking.service.CartService;
import com.arabsoft.HotelBooking.service.InventoryService;
import com.arabsoft.HotelBooking.service.ReservationService;

import java.util.List;


@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CartService cartService;
    private final InventoryService inventoryService;
    private final ReservationMapper reservationMapper = ReservationMapper.INSTANCE;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository,
     CartService cartService,
    InventoryService inventoryService
     ) {
        this.reservationRepository = reservationRepository;
        this.cartService = cartService;
        this.inventoryService = inventoryService;
    }

    @Override
    @Transactional
    public ReservationSummaryDTO createReservation(ReservationRequestDTO reservationRequest) {
        Reservation reservation = reservationMapper.toEntity(reservationRequest);
        reservationRepository.save(reservation);
        cartService.clearCart(reservationRequest.getCartId());

        List<RoomAssignment> roomAssignments = reservation.getRoomAssignments();
        roomAssignments.forEach(roomAssignment -> {
            Room room = roomAssignment.getRoom();
            inventoryService.holdRooms(room.getCategory().getId(), reservation.getCheckInDate(), reservation.getCheckOutDate(), 1);
        });
       

        return reservationMapper.toSummaryDto(reservation);
    }

    @Override
    public ReservationSummaryDTO getReservationSummary(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new ReservationNotFoundException("Reservation not found"));
        return reservationMapper.toSummaryDto(reservation);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new ReservationNotFoundException("Reservation not found"));

        List<RoomAssignment> roomAssignments = reservation.getRoomAssignments();
        roomAssignments.forEach(roomAssignment -> {
            Room room = roomAssignment.getRoom();
            inventoryService.releaseHold(room.getCategory().getId(), reservation.getCheckInDate(), reservation.getCheckOutDate(), 1);
        });
        
        reservationRepository.delete(reservation);
    }

    @Override
    public List<ReservationSummaryDTO> getBookerReservations(Long bookerId) {
        List<Reservation> reservations = reservationRepository.findByBookerId(bookerId);
        return reservationMapper.toSummaryDtos(reservations);
    }

}
