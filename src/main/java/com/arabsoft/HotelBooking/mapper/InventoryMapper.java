package com.arabsoft.HotelBooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.InventoryUpdateDTO;
import com.arabsoft.HotelBooking.entity.Inventory;


@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Mapping(source = "roomCategory.id", target = "roomCategoryId")
    InventoryUpdateDTO toDto(Inventory inventory);

    @Mapping(source = "roomCategoryId", target = "roomCategory.id")
    Inventory toEntity(InventoryUpdateDTO dto);
}