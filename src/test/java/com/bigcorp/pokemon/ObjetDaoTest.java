package com.bigcorp.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bigcorp.pokemon.testEspeceDao.ObjetDao;

@SpringBootTest
public class ObjetDaoTest {
    @Autowired
    ObjetDao objetDao;

    @Test
    public void testCreateObjet() {
        
    }
}