package com.bigcorp.pokemon.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.bigcorp.pokemon.model.Attaque;
import com.bigcorp.pokemon.service.AttaqueService;

@RestController
@RequestMapping("/attaques")
public class AttaqueController {

    @Autowired
    private AttaqueService attaqueService;

    @PostMapping
    public ResponseEntity<Attaque> creatAttaque(@RequestBody Attaque attaque) {
        Attaque createdAttaque = attaqueService.createAttaque(attaque);
        return new ResponseEntity<>(createdAttaque, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttaqueById(@PathVariable Integer id) {

        Optional<Attaque> attaqueById = attaqueService.getAttaqueById(id);
        if(attaqueById.isPresent()){
            return ResponseEntity.status(HttpStatus.OK)
                .body(attaqueById.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attaque not found");
        }
    }

    @GetMapping
    public List<Attaque> getAllAttaques() {
        return attaqueService.getAllAttaques();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttaque(@PathVariable Integer id) {
        attaqueService.deleteAttaque(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
