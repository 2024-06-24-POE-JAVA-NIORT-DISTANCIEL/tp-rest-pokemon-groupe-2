package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.PokemonDao;
import com.bigcorp.pokemon.model.Pokemon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    PokemonDao pokemonDao;


    @Transactional
    public Pokemon save(Pokemon pokemon){
        Pokemon savedPokemon = this.pokemonDao.save(pokemon);
        return savedPokemon;
    }

    public Pokemon findById(Integer id){
        Optional<Pokemon> optionalPokemon = this.pokemonDao.findById(id);
        return optionalPokemon.orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
       pokemonDao.deleteById(id);
    }

    public List<Pokemon> findAll() {
        return pokemonDao.findAll();
    }






}
