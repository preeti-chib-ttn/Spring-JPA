package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(columnDefinition = "id")
public class Bike extends Vehicle {
    private Integer engineCapacity;
}
