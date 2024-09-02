package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.EspeceDao;
import com.bigcorp.pokemon.dao.PokemonDao;
import com.bigcorp.pokemon.dto.PokemonDto;
import com.bigcorp.pokemon.model.Espece;
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


    @Autowired
    EspeceDao especeDao;


    public PokemonDto save(PokemonDto pokemonDto) {

        if (pokemonDto.getId() != null && !pokemonDao.existsById(pokemonDto.getId())) {
            throw new IllegalArgumentException("Aucun Pokémon trouvé pour l'identifiant : " + pokemonDto.getId());
        }

        Optional<Espece> espece = especeDao.findById(pokemonDto.getEspeceid());

        if (espece.isEmpty()) {
            throw new IllegalArgumentException("Aucun especes trouve pour l'id:" + pokemonDto.getEspeceid());
        }

        // Obtenir l'espèce trouvée
        Espece especetrouver = espece.get();
        //convertion DTO en entity
        Pokemon pokemon = toEntity(pokemonDto, especetrouver);

        // Appliquer les valeurs par défaut et les conditions spécifiées
        pokemon.setNiveau(1); // Niveau fixe à 1
        pokemon.setXp(0); // Points d'expérience fixés à 0
        pokemon.setPv_max(especetrouver.getPointsVieInitial()); // Points de vie maximum de l'espèce
        pokemon.setPv(pokemon.getPv_max()); // Points de vie actuels égaux aux points de vie maximum
        //sauvgarder pokemon
        pokemon = pokemonDao.save(pokemon);

        //convertir l'entité enDTO
        return toDto(pokemon);

    }

    // Méthode de mise à jour d'un Pokémon
    public PokemonDto updatePokemon(Integer id, PokemonDto pokemonDto) throws IllegalArgumentException {
        // Vérifier si le Pokémon existe dans la base de données
        Optional<Pokemon> optionalPokemon = pokemonDao.findById(id);
        if (!optionalPokemon.isPresent()) {
            throw new IllegalArgumentException("Aucun Pokémon trouvé pour l'identifiant : " + id);
        }

        // Obtenir l'entité Pokémon existante
        Pokemon existingPokemon = optionalPokemon.get();
        if (pokemonDto.getEspeceid() != null) {
            Optional<Espece> espece = especeDao.findById(pokemonDto.getEspeceid());
            if (espece.isEmpty()) {
                throw new IllegalArgumentException("Aucune espèce trouvée pour l'identifiant : " + pokemonDto.getEspeceid());
            }
            existingPokemon.setEspece(espece.get());
            existingPokemon.setPv_max(espece.get().getPointsVieInitial());
        }


        // Mettre à jour les champs nécessaires
        if (pokemonDto.getNom() != null) {
            existingPokemon.setNom(pokemonDto.getNom());
        }
        if (pokemonDto.getNiveau() != null) {
            existingPokemon.setNiveau(pokemonDto.getNiveau());
        }
        if (pokemonDto.getXp() != null) {
            existingPokemon.setXp(pokemonDto.getXp());
        }
        if (pokemonDto.getPv() != null) {
            existingPokemon.setPv(pokemonDto.getPv());
        }





        // Sauvegarder les modifications
        Pokemon updatedPokemon = pokemonDao.save(existingPokemon);

        // Retourner le DTO mis à jour
        return toDto(updatedPokemon);
    }

    public PokemonDto findById(Integer id) {
        Optional<Pokemon> optionalPokemon = this.pokemonDao.findById(id);
        return toDto(optionalPokemon.orElse(null));
    }

    @Transactional
    public boolean delete(Integer id) {
        boolean pokemonInDb = pokemonDao.existsById(id);

        // Test si le pokemon n'est pas présent en base
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!pokemonInDb) {
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
        pokemonDto.setEspeceid(pokemon.getEspece().getId());
        pokemonDto.setNomespece(pokemon.getEspece().getNom());
        pokemonDto.setPointsVieInitial(pokemon.getEspece().getPointsVieInitial());


        return pokemonDto;
    }

    /**
     * Convertit un DTO en entité.
     *
     * @param dto le DTO
     * @return l'entité resevation correspondante
     */
    private Pokemon toEntity(PokemonDto dto, Espece espece) {
        if (dto == null) {
            return null;
        }
        Pokemon pokemon = new Pokemon();

        pokemon.setId(dto.getId());
        pokemon.setNom(dto.getNom());
        pokemon.setNiveau(dto.getNiveau());
        pokemon.setXp(dto.getXp());
        pokemon.setPv(dto.getPv());
        pokemon.setPv_max(dto.getPv_max());
        pokemon.setEspece(espece);


        return pokemon;
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
