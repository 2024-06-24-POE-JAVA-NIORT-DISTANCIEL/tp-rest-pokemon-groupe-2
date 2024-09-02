package com.bigcorp.pokemon.dto;

import java.util.List;

import com.bigcorp.pokemon.model.Capacite;
import com.bigcorp.pokemon.model.Dresseur;
import com.bigcorp.pokemon.model.Espece;
import org.antlr.v4.runtime.misc.NotNull;

public class PokemonDto {
    private Integer id;

    private String nom;

    private Integer niveau;

    private Integer xp;

    private Integer pv;

    public int pv_max;

    @NotNull
    private Integer especeid;

    //les donnees de Espece
    private String nomespece;

    private int pointsVieInitial;

    private Dresseur dresseur;

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

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public int getPv_max() {
        return pv_max;
    }

    public void setPv_max(int pv_max) {
        this.pv_max = pv_max;
    }

//    public Espece getEspece() {
//        return espece;
//    }
//
//    public void setEspece(Espece espece) {
//        this.espece = espece;
//    }


    public Integer getEspeceid() {
        return especeid;
    }

    public void setEspeceid(Integer especeid) {
        this.especeid = especeid;
    }

    public String getNomespece() {
        return nomespece;
    }

    public void setNomespece(String nomespece) {
        this.nomespece = nomespece;
    }

    public int getPointsVieInitial() {
        return pointsVieInitial;
    }

    public void setPointsVieInitial(int pointsVieInitial) {
        this.pointsVieInitial = pointsVieInitial;
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
}