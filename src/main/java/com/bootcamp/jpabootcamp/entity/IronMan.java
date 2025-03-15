package com.bootcamp.jpabootcamp.entity;

import jakarta.persistence.Entity;

@Entity
public class IronMan extends Avenger {
    private String suitType;
    private String aiAssistant;
}
