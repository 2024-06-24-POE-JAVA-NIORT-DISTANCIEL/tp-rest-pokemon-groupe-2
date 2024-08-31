package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.EspeceDao;
import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.model.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/* 
@SpringBootTest
public class TestEspeceService {

    @Autowired
    private EspeceService especeService;

    @Autowired
    private EspeceDao especeDao;

    @BeforeEach
    public void setUp() {
        especeDao.deleteAll(); // Assure que la base est propre avant chaque test
    }

    @Test
    public void testSaveEspece(){
        Espece newEspece = new Espece();
        newEspece.setNom("Goupix");
        newEspece.setPointsVieInitial(1000);
        newEspece.setType(Type.FEU);

        System.out.println("Avant save");
        Espece savedEspece = especeDao.save(newEspece);

        System.out.println("Après save");
        Assertions.assertNotNull(savedEspece.getId());
        Assertions.assertEquals("Goupix", savedEspece.getNom());
    }

    @Test
    public void testGetAllEspeces() {
        Espece e1 = new Espece(null, "Insecateur", 100, 100, Type.INSECTE);
        Espece e2 = new Espece(null, "Racaillou", 80, 80, Type.ROCHE);

        especeService.save(e1);
        especeService.save(e2);

        List<Espece> especes = especeService.getAllEspeces();
        Assertions.assertEquals(2, especes.size());
    }

    @Test
    public void testDeleteEspece() {
        Espece espece = new Espece(null, "Carapuce", 85, 85, Type.EAU);
        Espece savedEspece = especeService.save(espece);

        //Suppression à partir de son Id
        especeService.delete(savedEspece.getId());

        Espece deletedEspece = especeService.findById(savedEspece.getId());
        Assertions.assertNull(deletedEspece);
    }
}
*/