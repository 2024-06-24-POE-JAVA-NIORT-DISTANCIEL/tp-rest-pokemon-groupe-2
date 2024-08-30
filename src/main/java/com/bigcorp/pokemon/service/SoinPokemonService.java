package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.PokemonDao;
import com.bigcorp.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoinPokemonService {
    @Autowired
    private PokemonDao pokemonDao;

    public Optional<Pokemon> findById(Integer id) {
        return pokemonDao.findById(id);
    }

    public String soignerPokemon(Integer id) {
        Optional<Pokemon> optionalPokemon = findById(id);
        if (optionalPokemon.isEmpty()) {
            return "Le Pokémon avec l'identifiant " + id + " n'existe pas.";
        }

        Pokemon pokemon = optionalPokemon.get();
        String nom = pokemon.getNom();

        pokemon.setPv(pokemon.getPv_max()); // Réinitialise les PV au maximum
        pokemonDao.save(pokemon);

        return "Le Pokémon " + nom + " a été soigné. Points de vie actuels : " + pokemon.getPv();
    }
}
