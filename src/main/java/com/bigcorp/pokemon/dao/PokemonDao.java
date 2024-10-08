package com.bigcorp.pokemon.dao;

import com.bigcorp.pokemon.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonDao extends CrudRepository<Pokemon,Integer> {

    /**
     * Recherche tous les pokemons par leur nom
     */
    public List<Pokemon> findByNom(String nom);

    /**
     * Recherche tous les pokemons par leur niveau
     */
    public List<Pokemon> findByNiveau(int niveau );


    /**
     * Recherche tous les pokemons par leur nompar , en ne tenant pas compte de la casse
     */
    public List<Pokemon> findByNomIgnoreCase(String nom);

    /**
     * Recherche tous les pokemons dont le nom contient une partie du nom donné
     * en paramètre (insensible à la casse) et triés par ordre croissant de nom.
     */
    List<Pokemon> findByNomContainingIgnoreCaseOrderByNomAsc(String nom);

    /**
     * Recherche tous les pokemons
     */
    List<Pokemon> findAll();

}
