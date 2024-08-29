package com.bigcorp.pokemon.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Attaque {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Integer pointsDegats;

    // COnstructeurs 
    public Attaque(){
    }

    public Attaque(String nom, Type type, Integer pointsDegats) {
        this.nom = nom;
        this.type = type;
        this.pointsDegats = pointsDegats;
    }

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getPointsDegats() {
        return pointsDegats;
    }

    public void setPointsDegats(Integer pointsDegats) {
        this.pointsDegats = pointsDegats;
    }

    @Override
    public String toString() {
        return "Attaque{" +
        "id=" + id +
        ", nom='" + nom + '\'' +
        ", type=" + type +
        ", pointsDegats=" + pointsDegats +
        '}';
    }
}