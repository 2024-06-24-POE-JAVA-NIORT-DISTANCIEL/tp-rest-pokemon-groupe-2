package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.EspeceDao;
import com.bigcorp.pokemon.model.Espece;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspeceService {

    @Autowired
    EspeceDao especeDao;

    @Transactional
    public Espece save(Espece espece){
        Espece savedEspece = this.especeDao.save(espece);
        return savedEspece;
    }

    // Récupérer toutes les espèces
    public List<Espece> getAllEspeces() {
        return (List<Espece>) especeDao.findAll();
    }

    public Espece findById(Integer id){
        Optional<Espece> optionalEspece = this.especeDao.findById(id);
        if(optionalEspece.isEmpty()){
            return null;
        }
        return optionalEspece.get();
    }

    @Transactional
    public void delete(Integer id) {
        especeDao.deleteById(id);
    }

    public Iterable<Espece> findAll(){
        return this.especeDao.findAll();
    }
}
