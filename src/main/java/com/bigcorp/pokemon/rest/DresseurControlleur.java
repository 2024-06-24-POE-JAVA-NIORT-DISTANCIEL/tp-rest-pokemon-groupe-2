package com.bigcorp.pokemon.rest;

import java.util.List;

import com.bigcorp.pokemon.dto.ObjetDto;
import com.bigcorp.pokemon.model.Achat;
import com.bigcorp.pokemon.model.Objet;
import com.bigcorp.pokemon.service.AchatService;
import com.bigcorp.pokemon.service.ObjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bigcorp.pokemon.dto.DresseurDto;
import com.bigcorp.pokemon.model.Dresseur;
import com.bigcorp.pokemon.service.DresseurService;


@RestController
@RequestMapping("/dresseurs")
public class DresseurControlleur {
    @Autowired
    DresseurService dresseurService;

    @Autowired
    AchatService achatService;

    @Autowired
    ObjetService objetService;

    // La variable si dessous est une regex qui vérifie si l'id est un nombre entre 0 et 9 ([0-9])
    // en sachant que l'on peut rencontrer 1 à n fois (*).
    // Cette regex nous permet de rencontrer plusieurs routes
    // /dresseurs/1
    // /dresseurs/27
    // Etc. 
    private final static String VERIFY_ID = "/{id:[0-9]*}";

    @GetMapping(VERIFY_ID)
    public ResponseEntity<?> getDresseurById(@PathVariable Integer id) {
        DresseurDto dresseurInDb = dresseurService.getById(id);

        if(dresseurInDb == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("L'ID de ce dresseur n'est pas trouvable.");
        }

        return ResponseEntity.status(HttpStatus.OK)
            .body(dresseurInDb);
    }

    @GetMapping("/{pseudoPart:[a-zA-Z]*}")
    public List<DresseurDto> getDresseursByPseudonymePart(@PathVariable String pseudoPart) {
        List<DresseurDto> dresseursByPseudonymePart = dresseurService.getDresseursByUsernamePart(pseudoPart);
        return dresseursByPseudonymePart;
    }

    @PostMapping
    public ResponseEntity<?> newDresseur(@RequestBody Dresseur dresseur) {
        if (dresseur.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Vous ne pouvez pas spécifier l'ID du dresseur. La base de donnée s'occupe de l'identifiant.");
        }

        if (dresseur.getPortefeuille() != null && dresseur.getPortefeuille() != 100) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Vous ne pouvez pas spécifier le montant du portefeuille du dresseur. Par défaut il doit être initialisé à 100.");
        }

        DresseurDto dresseurInDb = dresseurService.save(dresseur);

        return ResponseEntity.status(HttpStatus.OK)
            .body(dresseurInDb);
    }

    @DeleteMapping(VERIFY_ID)
    public ResponseEntity<?> deleteDresseurById(@PathVariable Integer id) {
        // ! Pensez à rajouter la suppression des instances des objets du dresseur dans la table Achat
        DresseurDto dresseurInDb = dresseurService.getById(id);

        // Test si la liste des pokemons (ici nous avons décider d'appeller la variable équipe) est vide
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        // Donc si le dresseur possède au moins 1 pokemon, la suppression du dresseur n'est pas autoriser
        if (!dresseurInDb.getEquipe().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Le dresseur possède au moins 1 pokemon. Vous ne pouvez donc pas le supprimer.");
        }

        dresseurService.deleteById(id);

        dresseurInDb = dresseurService.getById(id);

        if (dresseurInDb != null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body("Le dresseur a bien été supprimé.");
        }

    }

    @PutMapping("/achat/{dresseurId}/{objetId}")
    public ResponseEntity<?> acheterObjet(@PathVariable Integer dresseurId, @PathVariable Integer objetId) {
        DresseurDto dresseurDto = dresseurService.getById(dresseurId);
        if (dresseurDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le dresseur avec l'id fourni n'a pas été trouvé");
        }
        ObjetDto objetDto = objetService.findById(objetId);
        if (objetDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("l'objet avec l'id fourni n'a pas été trouvé");
        }
        Achat result = achatService.acheterObjet(dresseurDto, objetDto);
        return ResponseEntity.ok(result);
    }
}