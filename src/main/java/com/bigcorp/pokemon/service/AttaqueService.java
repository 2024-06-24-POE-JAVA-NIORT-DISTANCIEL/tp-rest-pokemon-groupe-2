package com.bigcorp.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.pokemon.dao.AttaqueDao;
import com.bigcorp.pokemon.model.Attaque;

import java.util.List;
import java.util.Optional;

@Service
public class AttaqueService {

    @Autowired
    private AttaqueDao attaqueDao;

    public Attaque creatAttaque(Attaque attaque) {
        return attaqueDao.save(attaque);
    }

    public Attaque createAttaque(Attaque attaque) {
        return attaqueDao.save(attaque);
    }

    public List<Attaque> getAllAttaques() {
        return (List<Attaque>) attaqueDao.findAll();
    }

    public Optional<Attaque> getAttaqueById(Integer id) {
        return attaqueDao.findById(id);
    }

    public void deleteAttaque(Integer id) {
        attaqueDao.deleteById(id);
    }

}
