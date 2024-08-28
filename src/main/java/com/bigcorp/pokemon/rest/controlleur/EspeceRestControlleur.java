package com.bigcorp.pokemon.rest.controlleur;

import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.model.Pokemon;
import com.bigcorp.pokemon.service.EspeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/especes")
public class EspeceRestControlleur {

    @Autowired
    EspeceService especeService;

    // Ajouter une nouvelle espèce
    @PostMapping
    public Espece addEspece(@RequestBody Espece espece) {
        return especeService.save(espece);
    }

    //Récuppération toutes les espèces
    @GetMapping
    public List<Espece> getAllEspeces() {
        return especeService.getAllEspeces();
    }

    //Récuppération par id
//    @GetMapping("/{id}")
//    public ResponseEntity<Espece> getEspeceById(@PathVariable Long id) {
//        Espece espece =  especeService.findById(id);
//        if(espece == null){
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//                    .body("Vous ne devez pas specifier l'ID de la Person, c'est la base qui va le créer.");
//        }
//        return ResponseEntity.ofNullable(espece);}



    //supprimer une espèce par id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspece(@PathVariable Long id) {
        especeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
