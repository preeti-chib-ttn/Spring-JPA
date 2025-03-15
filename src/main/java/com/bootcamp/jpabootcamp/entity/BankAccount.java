package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bank")
public class BankAccount extends Payment{
    private String accountNumber;
    private String bankName;
    private String ifscCode;
}
