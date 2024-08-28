package com.bigcorp.pokemon.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Espece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int initialHp;

    @OneToOne
    private Attack initialAttack;

    // Getters, Setters, Constructors
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String ) {
        this.type = type;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public void setInitialHp(int initialHp) {
        this.initialHp = initialHp;
    
}
