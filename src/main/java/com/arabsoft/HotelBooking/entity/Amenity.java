package com.arabsoft.HotelBooking.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
        name = "room_category_amenities",
        joinColumns = @JoinColumn(name = "amenity_id"),
        inverseJoinColumns = @JoinColumn(name = "room_category_id")
    )
    private Set<RoomCategory> roomCategories;
}