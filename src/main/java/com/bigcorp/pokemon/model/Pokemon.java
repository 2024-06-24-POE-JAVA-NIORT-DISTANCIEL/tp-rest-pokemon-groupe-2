package com.bigcorp.pokemon.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private int niveau;
    private int xp;
    private int pv;
    public int pv_max;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especeId")
    private Espece espece;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dresseurId")
    private Dresseur dresseur;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "capaciteId")
    private List<Capacite> capacites;

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

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Dresseur getDresseur() {
        return dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    public List<Capacite> getCapacites() {
        return capacites;
    }

    public void setCapacites(List<Capacite> capacites) {
        this.capacites = capacites;
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
