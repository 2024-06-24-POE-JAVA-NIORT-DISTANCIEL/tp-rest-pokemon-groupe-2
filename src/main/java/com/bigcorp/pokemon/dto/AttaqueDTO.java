package com.bigcorp.pokemon.dto;

import com.bigcorp.pokemon.model.Type;


public class AttaqueDTO { 
    private Integer id;
    private String nom;
    private Type type;
    private Integer pointsDegats;

    
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

    

}
