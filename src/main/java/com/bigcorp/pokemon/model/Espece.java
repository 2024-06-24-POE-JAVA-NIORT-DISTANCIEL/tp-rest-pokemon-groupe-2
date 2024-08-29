package com.bigcorp.pokemon.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Espece {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String nom;
    private int pointsVieInitial;

    @Column(name = "typeId", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type; // Liste pour contenir les types

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pokemonId")
//    private List<Pokemon> pokemons;


    // Constructeur
    public Espece(Integer id, String nom, int pointsVieInitial, int vieInitial, Type type) {
        this.id = id;
        this.nom = nom;
        this.pointsVieInitial = pointsVieInitial;
        this.type = type;
    }

    public Espece() {
    }

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

//    public List<Pokemon> getPokemons() {
//        return pokemons;
//    }
//
//    public void setPokemons(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }
}
