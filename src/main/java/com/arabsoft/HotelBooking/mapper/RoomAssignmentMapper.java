package com.arabsoft.HotelBooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.RoomAssignmentDTO;
import com.arabsoft.HotelBooking.entity.RoomAssignment;

@Mapper
public interface RoomAssignmentMapper {
    RoomAssignmentMapper INSTANCE = Mappers.getMapper(RoomAssignmentMapper.class);

    @Mapping(source = "room.roomNumber", target = "roomNumber")
    @Mapping(source = "room.category.name", target = "categoryName")
    RoomAssignmentDTO toDto(RoomAssignment roomAssignment);
}
