package com.bigcorp.pokemon.rest;

import com.bigcorp.pokemon.dto.EspeceDto;
import com.bigcorp.pokemon.dto.PokemonDto;
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
    public ResponseEntity<?> createPokemon(@RequestBody PokemonDto pokemon) {
        if (pokemon.getId() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier l'ID. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }
        
        if (pokemon.getNiveau() != null && pokemon.getNiveau() != 1) {
            return new ResponseEntity<>("Le niveau du pokemon doit être à 1.", HttpStatus.BAD_REQUEST);
        }
        
        if (pokemon.getXp() != null && pokemon.getXp() != 0) {
            return new ResponseEntity<>("L'exp' du pokemon doit être à 0.", HttpStatus.BAD_REQUEST);
        }
        
        // Ici, getEspece() est une référence à l'ID d'une espece
        if (pokemon.getEspeceid() == null) {
            return new ResponseEntity<>("L'espèce n'a pas été spécifier.", HttpStatus.BAD_REQUEST);
        }
        else {
            EspeceDto especeDto = especeService.findById(pokemon.getEspeceid());

            if (especeDto == null) {
                return new ResponseEntity<>("L'espèce avec l'id " + pokemon.getEspeceid() + " n'existe pas.", HttpStatus.BAD_REQUEST);
            }

            pokemon.setPv_max(especeDto.getPointsVieInitial());
        }

        if (pokemon.getPv() != null && pokemon.getPv() != pokemon.getPv_max()) {
            return new ResponseEntity<>("Les attribuits pv et pv_max doivent être égaux.", HttpStatus.BAD_REQUEST);
        }

        try {
            PokemonDto savedPokemon = pokemonService.save(pokemon);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPokemon);
        } catch (Exception e) {
            // Log l'erreur pour la déboguer plus tard
            e.printStackTrace();
            return ResponseEntity.badRequest().body("not created");
        }
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


        return ResponseEntity.ok("Pokemon supprimé");

    }

    @PutMapping("/{id}/soin")
    public ResponseEntity<String> soinPokemon(@PathVariable Integer id) {
        String result = soinPokemonService.soignerPokemon(id);
        return ResponseEntity.ok(result);
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePokemon(
            @PathVariable Integer id,
            @RequestBody PokemonDto pokemonDto) {
        if (pokemonDto.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vous ne pouvez pas modifier l'id du pokemon ");
        }

        try {
            // Appel du service pour mettre à jour le Pokémon
            PokemonDto updatedPokemon = pokemonService.updatePokemon(id, pokemonDto);

            // Retourne une réponse avec le Pokémon mis à jour
            return ResponseEntity.ok(updatedPokemon);
        } catch (IllegalArgumentException e) {
            // Si une exception est levée, retourne une réponse 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            // Gestion générale des erreurs, par exemple en retournant une réponse 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
