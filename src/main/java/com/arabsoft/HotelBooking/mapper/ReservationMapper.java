package com.arabsoft.HotelBooking.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.ReservationRequestDTO;
import com.arabsoft.HotelBooking.dto.ReservationSummaryDTO;
import com.arabsoft.HotelBooking.entity.Reservation;


@Mapper(uses = {BookerMapper.class, RoomAssignmentMapper.class})
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "booker", target = "booker")
    @Mapping(source = "roomAssignments", target = "roomAssignments")
    ReservationSummaryDTO toSummaryDto(Reservation reservation);

    @Mapping(target = "id", ignore = true)
    Reservation toEntity(ReservationRequestDTO dto);

    @Mapping(source = "booker", target = "booker")
    @Mapping(source = "roomAssignments", target = "roomAssignments")
    List<ReservationSummaryDTO> toSummaryDtos(List<Reservation> reservations);
}