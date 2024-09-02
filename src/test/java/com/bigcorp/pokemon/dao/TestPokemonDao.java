package com.bigcorp.pokemon.dao;

import com.bigcorp.pokemon.model.Pokemon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestPokemonDao {

    @Autowired
    PokemonDao pokemonDao;

//    @Test
//    public void testPokemonfindByNom(){
//
//        // Préparation des données
//        Pokemon p1 = new Pokemon();
//        p1.setNom("A");
//        pokemonDao.save(p1);
//
//        Pokemon p2 = new Pokemon();
//        p2.setNom("B");
//        pokemonDao.save(p2);
//
//        Pokemon p3 = new Pokemon();
//        p3.setNom("D");
//        pokemonDao.save(p3);
//
//            // Exécution de la méthode à tester
//        List<Pokemon> result = pokemonDao.findByNom("D");
//
//        // Vérification des résultats
//        Assertions.assertFalse(result.isEmpty());
//        System.out.println(result);
//    }
//
//    @Test
//    public void testFindByNomContainingIgnoreCase() {
//        // Créer et sauvegarder quelques Pokemon avec des noms différents
//        Pokemon p1 = new Pokemon();
//        p1.setNom("Dragon");
//        pokemonDao.save(p1);
//
//        Pokemon p2 = new Pokemon();
//        p2.setNom("pikatcho");
//        pokemonDao.save(p2);
//
//            // Rechercher tous les Pokemons dont le nom contient "dom", insensible à la casse
//        List<Pokemon> pokemons = pokemonDao.findByNomIgnoreCase("dragon");
////        System.out.println(pokemons);
//
//
//        Assertions.assertFalse(pokemons.isEmpty());
//    }

//    @Test
//    public void  testfindByNomContainingIgnoreCaseOrderByNomAsc (){
//
//        // Ajouter quelques Pokémons pour le test
//        Pokemon pikachu = new Pokemon();
//        pikachu.setNom("Pikachu");
//
//        pokemonDao.save(pikachu);
//
//        Pokemon raichu = new Pokemon();
//        raichu.setNom("Raichu");
//
//        pokemonDao.save(raichu);
//
//        Pokemon bulbasaur = new Pokemon();
//        bulbasaur.setNom("Bulbasaur");
//
//        pokemonDao.save(bulbasaur);
//
//
//        List<Pokemon> pokemons = pokemonDao.findByNomContainingIgnoreCaseOrderByNomAsc("chu");
//
//        // Vérifier que la liste contient deux Pokémons
//        Assertions.assertNotNull(pokemons);
//        System.out.println(pokemons);
//
//        // Vérifier que les résultats sont triés par nom
////        Assertions.assertEquals("Pikachu", pokemons.get(0).getNom());
////       Assertions.assertEquals("Raichu", pokemons.get(1).getNom());
//    }

    @Test
    public void save(){
        // Créer un nouvel objet Pokémon
        Pokemon pikachu = new Pokemon();
        pikachu.setNom("Pikachu");

        // Définir les autres propriétés requises
        pikachu.setNiveau(1); // Le niveau est fixé à 1 par défaut
        pikachu.setXp(0); // Les points d'expérience sont fixés à 0 par défaut
        pikachu.setPv(100); // Valeur d'exemple pour les points de vie actuels
        pikachu.setPv_max(100); // Valeur d'exemple pour les points de vie maximum

        // Sauvegarder l'objet Pokemon dans la base de données
        pokemonDao.save(pikachu);

        // Afficher l'objet pour vérifier
        System.out.println(pikachu);
    }


}