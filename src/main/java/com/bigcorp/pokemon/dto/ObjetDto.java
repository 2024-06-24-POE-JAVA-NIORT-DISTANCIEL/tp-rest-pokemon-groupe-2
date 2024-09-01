package com.bigcorp.pokemon.dto;

import java.util.List;

import com.bigcorp.pokemon.model.Achat;

public class ObjetDto {
    private Integer id;

    private String nom;

    private Integer cout;

    private String type;

    private List<Achat> achats;

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

    public Integer getCout() {
        return cout;
    }

    public void setCout(Integer cout) {
        this.cout = cout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }

    
}