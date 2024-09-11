package com.arabsoft.HotelBooking.controller;

import com.arabsoft.HotelBooking.dto.SearchRequestDTO;
import com.arabsoft.HotelBooking.dto.SearchResultDTO;
import com.arabsoft.HotelBooking.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public ResponseEntity<List<SearchResultDTO>> searchAvailableRooms(@RequestBody SearchRequestDTO searchRequest) {
        List<SearchResultDTO> results = searchService.searchAvailableRooms(searchRequest);
        return ResponseEntity.ok(results);
    }

    // @GetMapping("/availability")
    // public ResponseEntity<Boolean> checkAvailability(
    //         @RequestParam Long roomCategoryId,
    //         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
    //         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
    //         @RequestParam int quantity) {
    //     boolean isAvailable = searchService.checkAvailability(roomCategoryId, checkIn, checkOut, quantity);
    //     return ResponseEntity.ok(isAvailable);
    // }
}
