package com.bigcorp.pokemon.rest;

import com.bigcorp.pokemon.dto.EspeceDto;
import com.bigcorp.pokemon.dto.PokemonDto;
import com.bigcorp.pokemon.model.Pokemon;
import com.bigcorp.pokemon.service.DiscussionPokemonService;
import com.bigcorp.pokemon.service.EspeceService;
import com.bigcorp.pokemon.service.PokemonService;
import com.bigcorp.pokemon.service.SoinPokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonControlleur {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    DiscussionPokemonService discussionPokemonService;

    @Autowired
    EspeceService especeService;

    @Autowired
    SoinPokemonService soinPokemonService;

    @PostMapping
    public ResponseEntity<?> createPokemon(@RequestBody Pokemon pokemon) {
        if (pokemon.getId() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier l'ID. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        if (pokemon.getNiveau() != null || pokemon.getNiveau() != 1) {
            return new ResponseEntity<>("Le niveau du pokemon doit être à 1.", HttpStatus.BAD_REQUEST);
        }

        if (pokemon.getXp() != null || pokemon.getXp() != 0) {
            return new ResponseEntity<>("L'exp' du pokemon doit être à 0.", HttpStatus.BAD_REQUEST);
        }

        // Ici, getEspece() est une référence à l'ID d'une espece
        if (pokemon.getEspece() == null) {
            return new ResponseEntity<>("L'espèce n'a pas été spécifier.", HttpStatus.BAD_REQUEST);
        }
        else {
            EspeceDto especeDto = especeService.findById(pokemon.getEspece().getId());

            if (especeDto == null) {
                return new ResponseEntity<>("L'espèce avec l'id " + pokemon.getEspece().getId() + " n'existe pas.", HttpStatus.BAD_REQUEST);
            }

            pokemon.setPv_max(especeDto.getPointsVieInitial());
        }

        if (pokemon.getPv() != pokemon.getPv_max()) {
            return new ResponseEntity<>("Les attribuits pv et pv_max doivent être égaux.", HttpStatus.BAD_REQUEST);
        }

        PokemonDto createdPokemon = pokemonService.save(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }

    // Récupérer un Pokémon par son ID
    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable Integer id) {
        PokemonDto pokemonDto = pokemonService.findById(id);
        if (pokemonDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pokemonDto, HttpStatus.OK);
    }

    // Récupérer tous les Pokémon
    @GetMapping
    public ResponseEntity<List<PokemonDto>> getAllPokemon() {
        List<PokemonDto> pokemonsDto = pokemonService.findAll();
        return new ResponseEntity<>(pokemonsDto, HttpStatus.OK);
    }

    // Supprimer un Pokémon
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Integer id) {
        boolean estSupprime = pokemonService.delete(id);

        // Test si le pokemon n'a pas été supprimé
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!estSupprime) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pokemonService.delete(id);

        PokemonDto pokemonDto = pokemonService.findById(id);

        if (pokemonDto == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return ResponseEntity.ok("Pokemon supprimé");
        }
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

    // Endpoint pour soigner un Pokémon via son ID
    @PutMapping("/{id}/soin")
    public ResponseEntity<String> soinPokemon(@PathVariable Integer id) {
        String result = soinPokemonService.soignerPokemon(id);
        return ResponseEntity.ok(result);
    }
}
