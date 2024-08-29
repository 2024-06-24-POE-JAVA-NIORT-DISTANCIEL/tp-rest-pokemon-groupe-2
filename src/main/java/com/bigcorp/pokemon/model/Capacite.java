package com.bigcorp.pokemon.model;

import jakarta.persistence.*;

public class Capacite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attaqueId", nullable = false)
    private Attaque attaque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemonId", nullable = false)
    private Pokemon pokemon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attaque getAttaque() {
        return attaque;
    }

    public void setAttaque(Attaque attaque) {
        this.attaque = attaque;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
