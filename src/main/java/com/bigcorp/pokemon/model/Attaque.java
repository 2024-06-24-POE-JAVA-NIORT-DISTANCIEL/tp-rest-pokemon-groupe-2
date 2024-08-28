package com.bigcorp.pokemon.model;

public class Attaque {
    private int id;

    private String nom;

    private Type type;

    private Integer points_degats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getPoints_degats() {
        return points_degats;
    }

    public void setPoints_degats(Integer points_degats) {
        this.points_degats = points_degats;
    }
}
