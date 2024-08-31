package com.bigcorp.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.pokemon.dao.ObjetDao;
import com.bigcorp.pokemon.model.Objet;

import jakarta.transaction.Transactional;

@Service
public class ObjetService {
    @Autowired
    ObjetDao objetDao;

    public Objet save(Objet objet) {
        Objet objetInDb = objetDao.save(objet);
        return objetInDb;
    }

    public List<Objet> findBetweenMinAndMax(Integer min, Integer max) {
        List<Objet> objets = objetDao.findByCoutBetween(min, max);

        return objets;
    }

    public Objet findById(Integer id) {
        Optional<Objet> objetInDb = objetDao.findById(id);

        if (!objetInDb.isPresent()) {
            return null;
        }

        return objetInDb.get();
    }

    @Transactional
    public boolean delete(Integer id) {
        Optional<Objet> objetInDb = objetDao.findById(id);

        // Test si l'espèce n'est pas présente en base
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!objetInDb.isPresent()) {
            return false;
        }

        objetDao.deleteById(id);

        return true;
    }
}