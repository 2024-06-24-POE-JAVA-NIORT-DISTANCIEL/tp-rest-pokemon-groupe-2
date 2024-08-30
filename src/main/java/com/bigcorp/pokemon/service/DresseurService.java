package com.bigcorp.pokemon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.pokemon.dao.DresseurDao;
import com.bigcorp.pokemon.model.Dresseur;

import jakarta.transaction.Transactional;

@Service
public class DresseurService {
    @Autowired
    private DresseurDao dresseurDao;

    public Dresseur save(Dresseur dresseur) {
        Dresseur dresseurSaved = dresseurDao.save(dresseur);
        return dresseurSaved;
    }

    public Dresseur getById(Integer id) {
        Optional<Dresseur> dresseurInDb = dresseurDao.findById(id);
        
        if (!dresseurInDb.isPresent()) {
            return null;
        }

        return dresseurInDb.get();
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Dresseur> dresseurInDb = dresseurDao.findById(id);

        if (!dresseurInDb.isPresent()) {
            return;
        }

        dresseurDao.delete(dresseurInDb.get());
    }
}