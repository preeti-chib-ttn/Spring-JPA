package com.bootcamp.jpabootcamp.entity;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Author {


    @Embedded
    Address address;
}
