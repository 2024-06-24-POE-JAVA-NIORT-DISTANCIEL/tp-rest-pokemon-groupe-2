package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.PokemonDao;
import com.bigcorp.pokemon.model.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDiscussionPokemonService {
    @Autowired
    DiscussionPokemonService discussionPokemonService;

    @Autowired
    PokemonDao pokemonDao;

    @BeforeEach
    public void setUp() {
        pokemonDao.deleteAll(); // Assure que la base est propre avant chaque test
    }

    @Test
    public void testDiscussionPokemon() {
        Pokemon newPokemon = new Pokemon();
        newPokemon.setNom("Goupix");
        newPokemon.setPv(50);
        newPokemon.setPv_max(100);

        // Sauvegarde le nouveau Pokémon dans la base de données
        Pokemon savedPokemon = pokemonDao.save(newPokemon);

        // Appel le service pour faire parler le Pokémon
        String message = discussionPokemonService.faireParlerPokemon(savedPokemon.getId());

        // Vérifie que le message contient le nom du Pokémon entre 1 et 3 fois
        //Utiiisation du régex :
        // ^ : indique le début de la chaîne
        //() : défini un groupe capturant
        // Goupix ? : le groupe capturant, soit la chaîne de charactère Goupix + l'espace qui suit après (la signigication du  ?)
        // {1,3} : le quantificateur qui indique le groupe capturant doit apparaitre au moins 1X et au plus 3X
        // [] : défini une classe de caractères qui correspond à un caractère parmi ceux spécifiés
        //[.!?] : correspond à un seul caractère qui peut être soit un point (.), un point d'exclamation (!), ou un point d'interrogation (?)
        // $ : Fin de la chaîne
        Assertions.assertTrue(message.matches("^(Goupix ?){1,3}[.!?]$"),
                "Le message doit contenir le nom du Pokémon 'Goupix' répété 1 à 3 fois, suivi d'une ponctuation.");

        System.out.println("Message généré: " + message);
    }
}
