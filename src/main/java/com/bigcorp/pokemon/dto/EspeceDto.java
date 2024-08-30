package com.bigcorp.pokemon.dto;

import com.bigcorp.pokemon.model.Type;

public class EspeceDto {
    private Integer id;

    private String nom;
    
    private int pointsVieInitial;

    private Type type;

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