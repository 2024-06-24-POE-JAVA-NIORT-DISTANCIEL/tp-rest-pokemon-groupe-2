package com.bigcorp.pokemon.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Pokemon {
    private Integer id;
    private String nom;
    private int niveau;
    private int xp;
    private int pv;
    public int pv_max;


    private Espece espece;
    private Dresseur dresseur;



    public long getId() {
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

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv_max() {
        return pv_max;
    }

    public void setPv_max(int pv_max) {
        this.pv_max = pv_max;
    }

    @Override
    public String toString() {
        return "Pokemon(" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", xp=" + xp +
                ", pv=" + pv +
                ", pv_max=" + pv_max +
                ", espece=" + espece +
                ", dresseur=" + dresseur +
                ')';
    }
}
