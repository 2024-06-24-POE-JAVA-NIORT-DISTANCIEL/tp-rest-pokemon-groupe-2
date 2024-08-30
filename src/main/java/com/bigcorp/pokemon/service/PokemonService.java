package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.PokemonDao;
import com.bigcorp.pokemon.dto.PokemonDto;
import com.bigcorp.pokemon.model.Pokemon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    PokemonDao pokemonDao;

    public PokemonDto save(Pokemon pokemon){
        Pokemon savedPokemon = this.pokemonDao.save(pokemon);
        return toDto(savedPokemon);
    }

    public PokemonDto findById(Integer id){
        Optional<Pokemon> optionalPokemon = this.pokemonDao.findById(id);
        return toDto(optionalPokemon.orElse(null));
    }

    @Transactional
    public boolean delete(Integer id) {
        Optional<Pokemon> pokemonInDb = pokemonDao.findById(id);

        // Test si le pokemon n'est pas présent en base
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!pokemonInDb.isPresent()) {
            return false;
        }

        pokemonDao.deleteById(id);

        return true;
    }

    public List<PokemonDto> findAll() {
        return toDtoList(pokemonDao.findAll());
    }

    public PokemonDto toDto(Pokemon pokemon) {
        if (pokemon == null) {
            return null;
        }
 
        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setNom(pokemon.getNom());
        pokemonDto.setNiveau(pokemon.getNiveau());
        pokemonDto.setXp(pokemon.getXp());
        pokemonDto.setPv(pokemon.getPv());
        pokemonDto.setPv_max(pokemon.getPv_max());
        pokemonDto.setEspece(pokemon.getEspece());

        return pokemonDto;
    }

    public List<PokemonDto> toDtoList(List<Pokemon> pokemons) {
        List<PokemonDto> pokemonsDto = new ArrayList<>();

        for (Pokemon pokemon : pokemons) {
            PokemonDto currentPokemonToDto = toDto(pokemon);
            pokemonsDto.add(currentPokemonToDto);
        }

        return pokemonsDto;
    }
}
