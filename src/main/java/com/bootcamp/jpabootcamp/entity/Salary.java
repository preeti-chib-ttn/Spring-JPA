package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Salary {

    private double basicSalary;
    private double bonusSalary;
    private double taxAmount;
    private double specialAllowanceSalary;
}