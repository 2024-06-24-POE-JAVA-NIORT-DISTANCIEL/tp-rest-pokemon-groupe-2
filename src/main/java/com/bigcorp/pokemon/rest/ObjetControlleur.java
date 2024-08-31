package com.bigcorp.pokemon.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.pokemon.model.Objet;
import com.bigcorp.pokemon.service.ObjetService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/objets")
public class ObjetControlleur {
    @Autowired
    ObjetService objetService;

    // La variable si dessous est une regex qui vérifie si l'id est un nombre entre 0 et 9 ([0-9])
    // en sachant que l'on peut rencontrer 1 à n fois (*).
    // Cette regex nous permet de rencontrer plusieurs routes
    // /objets/1
    // /objet/27
    // Etc. 
    private final static String VERIFY_ID = "/{id:[0-9]*}";

    @GetMapping(VERIFY_ID)
    public ResponseEntity<?> getObjetById(@PathVariable Integer id) {
        Objet objetInDb = objetService.findById(id);

        if(objetInDb == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("L'ID de cet objet n'est pas trouvable.");
        }

        return ResponseEntity.status(HttpStatus.OK)
            .body(objetInDb);
    }

    @GetMapping("/{min}/{max}")
    public List<Objet> getObjetBetweenMinAndMax(@PathVariable Integer min, @PathVariable Integer max) {
        List<Objet> objetsBetweenMinAndMax = objetService.findBetweenMinAndMax(min, max);

        return objetsBetweenMinAndMax;
    }
    
    
    @PostMapping
    public Objet addObjet(@RequestBody Objet objet) {
        Objet objetInDb = objetService.save(objet);

        if (objetInDb == null) {
            return null;
        }

        return objetInDb;
    }
    
    @DeleteMapping(VERIFY_ID)
    public ResponseEntity<?> deleteObjet(@PathVariable Integer id) {
        //! Rajouter une condition lors qu'on aura fait le lien avec la table d'achats afin d'éviter de supprimer un objet
        //! s'il est déjà dans l'inventaire d'un dresseur.

        boolean estSupprime = objetService.delete(id);

        // Test si l'objet n'a pas été supprimé
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!estSupprime) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        objetService.delete(id);

        Objet objetInDb = objetService.findById(id);

        if (objetInDb != null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return ResponseEntity.ok("Objet supprimé");
        }
    } 
}