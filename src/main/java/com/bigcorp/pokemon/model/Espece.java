package com.bigcorp.pokemon.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
public class Espece {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nom;
    private int pointsVieInitial;

    @Enumerated(EnumType.STRING)
    private Type type; // Liste pour contenir les types

    // Constructeur
    public Espece(Long id, String nom, int pointsVieInitial, int vieInitial, Type type) {
        this.id = id;
        this.nom = nom;
        this.pointsVieInitial = pointsVieInitial;
        this.type = type;
    }

    public Espece() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsVieInitial() {
        return pointsVieInitial;
    }

    public void setPointsVieInitial(int pointsVieInitial) {
        this.pointsVieInitial = pointsVieInitial;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
    this.type = type;
    }
}
