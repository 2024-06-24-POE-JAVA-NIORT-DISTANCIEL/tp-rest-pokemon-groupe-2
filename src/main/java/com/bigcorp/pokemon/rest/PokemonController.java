package com.bigcorp.pokemon.rest;

import com.bigcorp.pokemon.model.Pokemon;
import com.bigcorp.pokemon.service.DiscussionPokemonService;
import com.bigcorp.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    DiscussionPokemonService discussionPokemonService;

    // Créer un nouveau Pokémon
//    @PostMapping
//    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
//
//        Pokemon createdPokemon = pokemonService.save(pokemon);
//        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon createdPokemon = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }

    // Récupérer un Pokémon par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Integer id) {
        Pokemon pokemon = pokemonService.findById(id);
        if (pokemon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    // Récupérer tous les Pokémon
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> pokemons = pokemonService.findAll();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    // Mettre à jour un Pokémon existant
    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Integer id, @RequestBody Pokemon pokemonDetails) {
        Pokemon pokemon = pokemonService.findById(id);
        if (pokemon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Mise à jour des détails du Pokémon
        pokemon.setNom(pokemonDetails.getNom());

        pokemon.setNiveau(pokemonDetails.getNiveau());

        Pokemon updatedPokemon = pokemonService.save(pokemon);
        return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
    }

    // Supprimer un Pokémon
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Integer id) {
        Pokemon pokemon = pokemonService.findById(id);
        if (pokemon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pokemonService.delete(id);
        return ResponseEntity.ok("Pokemon supprimé");
    }

    //Faire parler un pokémon
    @GetMapping("/{id}/speak")
    public ResponseEntity<String> makePokemonSpeak(@PathVariable Integer id) {
        String message = discussionPokemonService.faireParlerPokemon(id);
        if (message.startsWith("Le Pokémon avec l'identifiant")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.ok(message);
    }

}
