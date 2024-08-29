package com.bigcorp.pokemon.dao;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bigcorp.pokemon.model.Objet;

@SpringBootTest
public class ObjetDaoTest {
    @Autowired
    ObjetDao objetDao;

    @Test
    public void testCreateObjet() {
        Objet potion = new Objet();
        potion.setNom("Potion");
        potion.setCout(100);
        potion.setType("Sante");

        Objet objetSaved = objetDao.save(potion);

        Optional<Objet> objetInDb = objetDao.findById(objetSaved.getId());

        Assertions.assertTrue(objetInDb.isPresent());
        Assertions.assertEquals(potion.getNom(), objetInDb.get().getNom());
    }

    @Test
    public void testFindByCoutBetweenOptionnalMinAndMax() {
        Objet superPotion = new Objet();
        superPotion.setNom("Super potion");
        superPotion.setCout(250);
        superPotion.setType("Sante");

        Objet guerison = new Objet();
        guerison.setNom("Guerison");
        guerison.setCout(3000);
        guerison.setType("Sante");

        Objet ppPlus = new Objet();
        ppPlus.setNom("PP plus");
        ppPlus.setCout(12000);
        ppPlus.setType("Combat");

        objetDao.save(superPotion);
        objetDao.save(guerison);
        objetDao.save(ppPlus);

        List<Objet> objetsCherInDb = objetDao.findByCoutBetween(2000, 13000);

        Assertions.assertFalse(objetsCherInDb.isEmpty());
        Assertions.assertEquals(2, objetsCherInDb.size());
    }
}