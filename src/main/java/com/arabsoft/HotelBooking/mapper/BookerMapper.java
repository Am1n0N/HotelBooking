package com.arabsoft.HotelBooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.arabsoft.HotelBooking.dto.BookerDTO;
import com.arabsoft.HotelBooking.entity.Booker;

@Mapper
public interface BookerMapper {
    BookerMapper INSTANCE = Mappers.getMapper(BookerMapper.class);

    BookerDTO toDto(Booker booker);
    Booker toEntity(BookerDTO dto);
    void updateFromDto(BookerDTO dto, Booker entity);
}
