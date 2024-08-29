package com.bigcorp.pokemon.rest;

import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.model.Pokemon;
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




    // Créer un nouveau Pokémon
    @PostMapping
    public ResponseEntity<?> createPokemon(@RequestBody Pokemon pokemon) {
        if(pokemon.getNiveau()!=null){

             return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                     .body("vous ne pouvez pas specifié le niveau de pokemon");

        }


        // Sauvegarde du Pokémon en utilisant le service
        Pokemon createdPokemon = pokemonService.save(pokemon);

        // Retourner une réponse HTTP 201 CREATED avec le Pokémon créé
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


}
