package com.bigcorp.pokemon.testEspeceDao;

import com.bigcorp.pokemon.model.Espece;
import com.bigcorp.pokemon.model.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
