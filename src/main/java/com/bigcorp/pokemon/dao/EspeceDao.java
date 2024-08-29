package com.bigcorp.pokemon.dao;

import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EspeceDao extends CrudRepository<Espece,Integer> {

    /**
     * Recherche tous les pokemons par leur nom
     */
    public List<Espece> findByNom(String nom);

    /**
     * Recherche tous les pokemons par leur nompar , en ne tenant pas compte de la casse
     */
    public List<Espece> findByNomIgnoreCase(String nom);

}
