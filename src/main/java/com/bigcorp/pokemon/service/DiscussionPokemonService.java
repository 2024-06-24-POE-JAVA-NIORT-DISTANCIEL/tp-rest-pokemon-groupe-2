package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.PokemonDao;
import com.bigcorp.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class DiscussionPokemonService {

    @Autowired
    private PokemonDao pokemonDao;

    public Optional<Pokemon> findById(Integer id) {
        return pokemonDao.findById(id);
    }

    public String faireParlerPokemon(Integer id) {
        Optional<Pokemon> optionalPokemon = findById(id);
        if (optionalPokemon.isEmpty()) {
            return "Le Pokémon avec l'identifiant " + id + " n'existe pas.";
        }

        Pokemon pokemon = optionalPokemon.get();
        String nom = pokemon.getNom();

        Random random = new Random(); //Un générateur de random

        // Répéter le nom 1 à 3 fois
        int repeatCount = random.nextInt(3) + 1; // le fait 1 fois puis répète entre 1 à 3
        String message = "" ;
        for (int i = 0; i < repeatCount; i++){
            if (i < repeatCount - 1) {
                message += nom + " ";
            }
            else {
                message += nom;
            }
        }

        // Ajouter un signe de ponctuation aléatoire
        char[] punctuations = {'.', '!', '?'};
        char punctuation = punctuations[random.nextInt(punctuations.length)];

        return message + punctuation;
    }
}