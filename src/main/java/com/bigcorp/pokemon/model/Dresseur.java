package com.bigcorp.pokemon.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Dresseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String pseudonyme;

    private String motDePasse;

    private Integer portefeuille = 100;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemonId")
    private List<Pokemon> equipe = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "achatId")
    private List<Achat> inventaire = new ArrayList<>();

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