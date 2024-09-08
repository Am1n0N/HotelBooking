package com.arabsoft.HotelBooking.user.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("GUEST")
public class User extends Person{
    private String cin;
    private String passportNumber;
}
