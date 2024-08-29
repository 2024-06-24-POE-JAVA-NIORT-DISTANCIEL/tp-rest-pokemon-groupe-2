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
    public void testEspecefindByNom(){

        // Préparation des données
        Espece e1 = new Espece();
        e1.setNom("Salamèche");
        e1.setType(Type.FEU);
        especeDao.save(e1);

        Espece e2 = new Espece();
        e2.setNom("Arkanin");
        e2.setType(Type.FEU);
        especeDao.save(e2);

        Espece e3 = new Espece();
        e3.setNom("Goupix");
        e3.setType(Type.FEU);
        especeDao.save(e3);

        // Exécution de la méthode à tester
        List<Espece> result = especeDao.findByNom("Goupix");

        // Vérification des résultats
        Assertions.assertFalse(result.isEmpty());
        System.out.println(result);
    }

    @Test
    public void testEspecefindByNomContainingIgnoreCase(){

        // Préparation des données
        Espece e1 = new Espece();
        e1.setNom("Salamèche");
        e1.setType(Type.FEU);
        especeDao.save(e1);

        Espece e2 = new Espece();
        e2.setNom("Arkanin");
        e2.setType(Type.FEU);
        especeDao.save(e2);

        Espece e3 = new Espece();
        e3.setNom("Goupix");
        e3.setType(Type.FEU);
        especeDao.save(e3);

        // Exécution de la méthode à tester
        List<Espece> result = especeDao.findByNomIgnoreCase("Gou");

        // Vérification des résultats
        Assertions.assertFalse(result.isEmpty());
        System.out.println(result);
    }

}
