package com.arabsoft.HotelBooking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.HotelBooking.dto.BookerDTO;
import com.arabsoft.HotelBooking.entity.Booker;
import com.arabsoft.HotelBooking.mapper.BookerMapper;
import com.arabsoft.HotelBooking.repository.BookerRepository;
import com.arabsoft.HotelBooking.service.BookerService;



@Service
public class BookerServiceImpl implements BookerService {
    private final BookerRepository bookerRepository;
    private final BookerMapper bookerMapper = BookerMapper.INSTANCE;

    public BookerServiceImpl(BookerRepository bookerRepository) {
        this.bookerRepository = bookerRepository;
    }

    @Override
    @Transactional
    public BookerDTO createBooker(BookerDTO bookerDTO) {
        Booker booker = bookerMapper.toEntity(bookerDTO);
        booker = bookerRepository.save(booker);
        return bookerMapper.toDto(booker);
    }

    @Override
    @Transactional
    public BookerDTO getBooker(Long bookerId) {
        Booker booker = bookerRepository.findById(bookerId).orElse(null);
        return bookerMapper.toDto(booker);
    }

    @Override
    @Transactional
    public void updateBooker(BookerDTO bookerDTO) {
        Booker booker = bookerRepository.findById(bookerDTO.getBookerId())
            .orElseThrow(() -> new IllegalArgumentException("Booker not found"));
        bookerMapper.updateFromDto(bookerDTO, booker);
        bookerRepository.save(booker);
    }
}