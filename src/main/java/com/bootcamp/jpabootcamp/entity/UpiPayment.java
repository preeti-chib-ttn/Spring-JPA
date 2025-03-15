package com.bootcamp.jpabootcamp.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "upi")
public class UpiPayment extends Payment{

    private String upiId;
}
