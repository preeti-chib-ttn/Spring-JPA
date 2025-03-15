package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.*;



@Entity
public class EmbeddedEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @Embedded
    private Salary salary;
}
