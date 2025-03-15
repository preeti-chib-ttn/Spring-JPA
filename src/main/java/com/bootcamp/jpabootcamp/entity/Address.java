package com.bootcamp.jpabootcamp.entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private int streetNumber;
    private String location;
    private String state;
}
