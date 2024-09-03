//package com.bigcorp.pokemon.service;
//
//import com.bigcorp.pokemon.dao.AchatDao;
//import com.bigcorp.pokemon.dao.DresseurDao;
//import com.bigcorp.pokemon.dao.ObjetDao;
//import com.bigcorp.pokemon.model.Achat;
//import com.bigcorp.pokemon.model.Dresseur;
//import com.bigcorp.pokemon.model.Objet;
//import com.bigcorp.pokemon.model.Pokemon;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class TestAchatService {
//    @Autowired
//    AchatService achatService;
//
//    @Autowired
//    AchatDao achatDao;
//
//    @Autowired
//    DresseurDao dresseurDao;
//
//    @Autowired
//    ObjetDao objetDao;
//
//    @BeforeEach
//    public void setUp() {
//        dresseurDao.deleteAll();
//        objetDao.deleteAll();
//        achatDao.deleteAll();// Assure que la base est propre avant chaque test
//    }
//
//    @Test
//    public void testAcheterObjet() {
//        // Initialisation des objets de test
//        Dresseur newDresseur = new Dresseur();
//        newDresseur.setId(1);
//        newDresseur.setPseudonyme("Ash");
//        newDresseur.setPortefeuille(150); // Le dresseur a 150 unités d'argent
//
//        // Sauvegarde le nouveau Dresseur dans la base de données
//        Dresseur savedDresseur = dresseurDao.save(newDresseur);
//
//        Objet newObjet = new Objet();
//        newObjet.setId(1);
//        newObjet.setNom("Potion");
//        newObjet.setCout(50); // Le coût de l'objet est de 50 unités d'argent
//
//        // Sauvegarde un nouvel objet dans la base de données
//        Objet savedObjet = objetDao.save(newObjet);
//
//        // Appel du service d'achat
//        Achat achat = achatService.acheterObjet(dresseur, objet);
//
//    }
//}
