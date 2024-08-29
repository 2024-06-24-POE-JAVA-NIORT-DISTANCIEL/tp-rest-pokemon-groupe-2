package com.bigcorp.pokemon.dao;

import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.model.Pokemon;
import com.bigcorp.pokemon.model.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestEspeceDao {

    @Autowired
    EspeceDao especeDao;

    @Test
    public void testSaveEspece(){
    Espece newEspece = new Espece();
    newEspece.setNom("bipède");
    newEspece.setPointsVieInitial(1000);
    newEspece.setType(Type.FEU);

    System.out.println("Avant save");
    Espece savedEspece = especeDao.save(newEspece);

    System.out.println("Après save");
    Assertions.assertNotNull(savedEspece.getId());
    Assertions.assertEquals("bipède", savedEspece.getNom());
    }

    @Test
    public void testEspecefindByNom(){

        // Préparation des données
        Espece e1 = new Espece();
        e1.setNom("Volatile");
        especeDao.save(e1);

        Espece e2 = new Espece();
        e2.setNom("Canide");
        especeDao.save(e2);

        Espece e3 = new Espece();
        e3.setNom("Félin");
        especeDao.save(e3);

        // Exécution de la méthode à tester
        List<Espece> result = especeDao.findByNom("Félin");

        // Vérification des résultats
        Assertions.assertFalse(result.isEmpty());
        System.out.println(result);
    }

    @Test
    public void testEspecefindByNomContainingIgnoreCase(){

        // Préparation des données
        Espece e1 = new Espece();
        e1.setNom("Volatile");
        especeDao.save(e1);

        Espece e2 = new Espece();
        e2.setNom("Canide");
        especeDao.save(e2);

        Espece e3 = new Espece();
        e3.setNom("Félin");
        especeDao.save(e3);

        // Exécution de la méthode à tester
        List<Espece> result = especeDao.findByNomIgnoreCase("Fél");

        // Vérification des résultats
        Assertions.assertFalse(result.isEmpty());
        System.out.println(result);
    }

}
