package com.bigcorp.pokemon.dto;

import java.util.List;

import com.bigcorp.pokemon.model.Achat;
import com.bigcorp.pokemon.model.Pokemon;

public class DresseurDto {
    private Integer id;

    private String pseudonyme;

    private String motDePasse;

    private Integer portefeuille;

    private List<Pokemon> equipe;

    private List<Achat> inventaire;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Integer getPortefeuille() {
        return portefeuille;
    }

    public void setPortefeuille(Integer portefeuille) {
        this.portefeuille = portefeuille;
    }

    public List<Pokemon> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Pokemon> equipe) {
        this.equipe = equipe;
    }

    public List<Achat> getInventaire() {
        return inventaire;
    }

    public void setInventaire(List<Achat> inventaire) {
        this.inventaire = inventaire;
    }

    
}
