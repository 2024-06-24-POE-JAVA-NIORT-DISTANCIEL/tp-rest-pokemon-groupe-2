package com.bigcorp.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bigcorp.pokemon.model.AttaquePack.AttaqueService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AttaqueServiceTest {

    @Autowired
    private AttaqueService attaqueService;

    @Test
    public void testCreateAttaque() {
        Attaque attaque = new Attaque("Lance-Flammes", Type.FEU, 90);
        Attaque createAttaque = attaqueService.creatAttaque(attaque);

        assertNotNull(createdAttaque.getId());
        assertEquals("Lance-Flammes", createdAttaque.getNom());
    }

}
