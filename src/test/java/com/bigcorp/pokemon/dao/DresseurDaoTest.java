package com.bigcorp.pokemon.dao;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bigcorp.pokemon.model.Dresseur;

@SpringBootTest
public class DresseurDaoTest {
    @Autowired
    DresseurDao dresseurDao;

    @Test
    public void testCreateDresseur() {
        Dresseur serge = new Dresseur();
        serge.setPseudonyme("SergePoke");
        serge.setMotDePasse("1234");
        
        Dresseur myDresseur = dresseurDao.save(serge);

        Optional<Dresseur> dresseurInDb = dresseurDao.findById(myDresseur.getId());

        Assertions.assertTrue(dresseurInDb.isPresent());
        Assertions.assertNotNull(dresseurInDb.get());
        Assertions.assertEquals(100, dresseurInDb.get().getPortefeuille());
    }

    @Test
    public void testGetDresseursByUsernamePart() {
        Dresseur flobert = new Dresseur();
        flobert.setPseudonyme("Flobert");
        flobert.setMotDePasse("1234");

        Dresseur florence = new Dresseur();
        florence.setPseudonyme("Florence");
        florence.setMotDePasse("4321");

        Dresseur iris = new Dresseur();
        iris.setPseudonyme("Iris");
        iris.setMotDePasse("4123");

        dresseurDao.save(flobert);
        dresseurDao.save(florence);
        dresseurDao.save(iris);

        List<Dresseur> dresseursByUsernamePartIgnoreCase = dresseurDao.findByPseudonymeContainingIgnoreCaseOrderByPseudonyme("fLO");

        String[] pseudoDresseurs = { "Flobert", "Florence" };

        Assertions.assertFalse(dresseursByUsernamePartIgnoreCase.isEmpty());
        Assertions.assertEquals(2, dresseursByUsernamePartIgnoreCase.size());
        
        int i = 0;

        for (Dresseur dresseur : dresseursByUsernamePartIgnoreCase) {
            Assertions.assertEquals(pseudoDresseurs[i], dresseur.getPseudonyme());
            i ++;
        }
    }
}