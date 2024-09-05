package com.arabsoft.HotelBooking.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal basePrice;
    private int totalRooms;

    @OneToMany(mappedBy = "roomCategory")
    private List<Room> rooms;

    @OneToMany(mappedBy = "roomCategory")
    private List<DailyInventory> dailyInventories;

    @ManyToMany(mappedBy = "roomCategories")
    private Set<Amenity> amenities;

    // Method to get inventory for a specific date
    public DailyInventory getInventoryForDate(LocalDate date) {
        return dailyInventories.stream()
            .filter(inventory -> inventory.getDate().equals(date))
            .findFirst()
            .orElse(null);
    }


}
