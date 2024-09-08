package com.arabsoft.HotelBooking.user.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Guest extends Person{
    private int age;

    private String gender;
    
    private boolean isAdult;
}
