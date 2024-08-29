package com.bigcorp.pokemon.model;

import jakarta.persistence.*;

@Entity
public class Achat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dresseurId", nullable = false)
    private Dresseur dresseur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objetId", nullable = false)
    private Objet objet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dresseur getDresseur() {
        return dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }
}
