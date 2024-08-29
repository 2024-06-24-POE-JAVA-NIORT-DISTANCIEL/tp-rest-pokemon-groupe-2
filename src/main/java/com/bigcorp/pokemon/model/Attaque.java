package com.bigcorp.pokemon.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attaque {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @OneToOne
    @JoinColumn(name = "typeId", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private Integer pointsDegats;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "capaciteId", nullable = false)
    private List<Capacite> capacite;


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

    public List<Capacite>  getCapacite() {
        return capacite;
    }

    public void setCapacite(List<Capacite>  capacite) {
        this.capacite = capacite;
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