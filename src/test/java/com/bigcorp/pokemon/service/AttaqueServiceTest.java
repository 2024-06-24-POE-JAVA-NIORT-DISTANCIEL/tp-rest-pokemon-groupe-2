package com.bigcorp.pokemon.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bigcorp.pokemon.model.AttaquePack.Attaque;
import com.bigcorp.pokemon.service.AttaqueService;
import com.bigcorp.pokemon.model.Type;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AttaqueServiceTest {

    @Autowired
    private AttaqueService attaqueService;

    @Test
    public void testCreateAttaque() {
        Attaque attaque = new Attaque("Lance-Flammes", Type.FEU, 90);
        Attaque createAttaque = attaqueService.creatAttaque(attaque);

        assertNotNull(createAttaque.getId());
        assertEquals("Lance-Flammes", createAttaque.getNom());
    }

}
