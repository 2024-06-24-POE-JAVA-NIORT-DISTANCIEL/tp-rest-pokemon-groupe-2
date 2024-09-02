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

        // Appel le service de soin pour soigner le Pokémon
        String result = discussionPokemonService.faireParlerPokemon(savedPokemon.getId());

        // Récupére le Pokémon mis à jour de la base de données
        Pokemon aguerrirPokemon = pokemonDao.findById(savedPokemon.getId()).orElse(null);

        // Vérifie que le Pokémon existe
        Assertions.assertNotNull(aguerrirPokemon, "Le Pokémon doit être présent dans la base de données.");
    }
}
