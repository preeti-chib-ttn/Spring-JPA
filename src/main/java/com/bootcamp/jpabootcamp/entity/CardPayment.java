package com.bootcamp.jpabootcamp.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "card")
public class CardPayment extends Payment{
    private String cardNumber;
}
