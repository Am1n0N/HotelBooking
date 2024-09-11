package com.arabsoft.HotelBooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.SearchRequestDTO;
import com.arabsoft.HotelBooking.dto.SearchResultDTO;
import com.arabsoft.HotelBooking.entity.RoomCategory;
import com.arabsoft.HotelBooking.utils.SearchCriteria;

@Mapper
public interface SearchMapper {
    SearchMapper INSTANCE = Mappers.getMapper(SearchMapper.class);

    SearchCriteria toEntity(SearchRequestDTO dto);
    SearchResultDTO toDto(RoomCategory roomCategory);
}
