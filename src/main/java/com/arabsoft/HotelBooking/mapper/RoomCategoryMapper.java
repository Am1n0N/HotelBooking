package com.arabsoft.HotelBooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.RoomCategoryDTO;
import com.arabsoft.HotelBooking.entity.RoomCategory;

import java.util.List;

@Mapper
public interface RoomCategoryMapper {
    RoomCategoryMapper INSTANCE = Mappers.getMapper(RoomCategoryMapper.class);

    RoomCategoryDTO toDto(RoomCategory roomCategory);
    RoomCategory toEntity(RoomCategoryDTO dto);

    List<RoomCategoryDTO> toDtos(List<RoomCategory> roomCategories);
    List<RoomCategory> toEntities(List<RoomCategoryDTO> dtos);

    void updateFromDto(RoomCategoryDTO dto, @MappingTarget RoomCategory entity);
}