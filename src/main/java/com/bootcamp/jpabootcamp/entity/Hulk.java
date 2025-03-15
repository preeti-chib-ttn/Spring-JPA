package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.Entity;

@Entity
public class Hulk extends Avenger {
    private int rageLevel;
    private boolean canTransform;
}
