package com.bootcamp.jpabootcamp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(columnDefinition = "id")
public class Car extends Vehicle {
    private Integer seatingCapacity;
    private String fuelType;
}
