package com.arabsoft.HotelBooking.dto;

import lombok.Data;

@Data
public class BookerDTO {
    private Long bookerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
