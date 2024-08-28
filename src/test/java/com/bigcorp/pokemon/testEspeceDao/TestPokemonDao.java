package com.bigcorp.pokemon.dao;

import com.bigcorp.pokemon.model.Pokemon;
import com.bigcorp.pokemon.resources.ConfigTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringBootTest
public class TestPokemonDao {

    @Autowired
    PokemonDao pokemonDao;

    @Test
    public void testPokemonfindByNom(){

        // Préparation des données
        Pokemon p1 = new Pokemon();
        p1.setNom("A");
        pokemonDao.save(p1);

        Pokemon p2 = new Pokemon();
        p2.setNom("B");
        pokemonDao.save(p2);

        Pokemon p3 = new Pokemon();
        p3.setNom("D");
        pokemonDao.save(p3);

            // Exécution de la méthode à tester
        List<Pokemon> result = pokemonDao.findByNom("D");

        // Vérification des résultats
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        System.out.println(result);
    }
    @Test
    public void testFindByNomContainingIgnoreCase() {
        // Créer et sauvegarder quelques Pokemon avec des noms différents
        Pokemon p1 = new Pokemon();
        p1.setNom("Dragon");
        pokemonDao.save(p1);

        Pokemon p2 = new Pokemon();
        p2.setNom("pikatcho");
        pokemonDao.save(p2);

            // Rechercher tous les Pokemons dont le nom contient "dom", insensible à la casse
        List<Pokemon> pokemons = pokemonDao.findByNomIgnoreCase("dragon");


        Assertions.assertEquals(1,pokemons.size());
    }
}