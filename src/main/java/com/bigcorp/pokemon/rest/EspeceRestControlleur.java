package com.bigcorp.pokemon.rest;

import com.bigcorp.pokemon.dto.EspeceDto;
import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.service.EspeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especes")
public class EspeceRestControlleur {

    @Autowired
    EspeceService especeService;

    // Ajouter une nouvelle espèce
    @PostMapping
    public EspeceDto addEspece(@RequestBody Espece espece) {
        EspeceDto especeDto = especeService.save(espece);

        if (especeDto == null) {
            return null;
        }

        return especeDto;
    }

    //Récuppération toutes les espèces
    @GetMapping
    public List<EspeceDto> getAllEspeces() {
        return especeService.getAllEspeces();
    }

    //Récuppération par id
    @GetMapping("/{id}")
    public ResponseEntity<?> getEspeceById(@PathVariable Integer id) {
        EspeceDto especeDto =  especeService.findById(id);

        if(especeDto == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("L'ID de cette Espece n'est pas trouvable.");
        }

        return ResponseEntity.status(HttpStatus.OK)
            .body(especeDto);
    }


    //supprimer une espèce par id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEspece(@PathVariable Integer id) {
        boolean estSupprime = especeService.delete(id);

        // Test si l'espèce n'a pas été supprimée
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!estSupprime) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        especeService.delete(id);

        EspeceDto especeDto = especeService.findById(id);

        if (especeDto == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return ResponseEntity.ok("Espèce supprimée");
        }
    }
}
