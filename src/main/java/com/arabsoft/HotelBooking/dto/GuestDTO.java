package com.arabsoft.HotelBooking.dto;

import lombok.Data;

@Data
public class GuestDTO {
    private Long guestId;
    private String firstName;
    private String lastName;
    private int age;
}
