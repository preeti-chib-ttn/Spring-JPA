package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.Entity;

@Entity
public class Thor extends Avenger {
    private String hammerType;
    private boolean canSummonLightning;
}
