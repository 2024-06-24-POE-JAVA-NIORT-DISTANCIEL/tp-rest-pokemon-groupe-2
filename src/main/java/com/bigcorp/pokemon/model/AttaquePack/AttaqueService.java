package com.bigcorp.pokemon.model.AttaquePack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttaqueService {

    @Autowired
    private AttaqueRepository attaqueRepository;

    public Attaque creatAttaque(Attaque attaque) {
        return attaqueRepository.save(attaque);
    }

    public Attaque createAttaque(Attaque attaque) {
        return attaqueRepository.save(attaque);
    }

    public List<Attaque> getAllAttaques() {
        return attaqueRepository.findAll();
    }

    public Optional<Attaque> getAttaqueById(Integer id) {
        return attaqueRepository.findById(id);
    }

    public void deleteAttaque(Integer id) {
        attaqueRepository.deleteById(id);
    }

}
