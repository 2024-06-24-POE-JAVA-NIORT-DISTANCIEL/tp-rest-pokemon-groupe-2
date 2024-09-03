package com.bigcorp.pokemon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bigcorp.pokemon.dto.DresseurDto;
import com.bigcorp.pokemon.model.Dresseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.pokemon.dao.ObjetDao;
import com.bigcorp.pokemon.dto.ObjetDto;
import com.bigcorp.pokemon.model.Objet;

import jakarta.transaction.Transactional;

@Service
public class ObjetService {
    @Autowired
    ObjetDao objetDao;

    public ObjetDto save(Objet objet) {
        Objet objetInDb = objetDao.save(objet);
        return toDto(objetInDb);
    }

    public List<ObjetDto> findBetweenMinAndMax(Integer min, Integer max) {
        List<Objet> objets = objetDao.findByCoutBetween(min, max);

        return toDtoList(objets);
    }

    public ObjetDto findById(Integer id) {
        Optional<Objet> objetInDb = objetDao.findById(id);

        if (!objetInDb.isPresent()) {
            return null;
        }

        return toDto(objetInDb.get());
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

    private ObjetDto toDto(Objet objet) {
        if (objet == null) {
            return null;
        }

        ObjetDto objetDto = new ObjetDto();

        objetDto.setId(objet.getId());
        objetDto.setNom(objet.getNom());
        objetDto.setCout(objet.getCout());
        objetDto.setType(objet.getType());
        objetDto.setAchats(objet.getAchats());

        return objetDto;
    }

    public List<ObjetDto> toDtoList(List<Objet> objets) {
        List<ObjetDto> objetsDto = new ArrayList<>();

        for (Objet objet : objets) {
            ObjetDto currentObjetToDto = toDto(objet);
            objetsDto.add(currentObjetToDto);
        }

        return objetsDto;
    }

    //Pour convertir de DTO > Entitée
    public Objet toEntity(ObjetDto objetDto) {
        if (objetDto == null) {
            return null;
        }
        Objet objet = new Objet();

        objet.setId(objetDto.getId());
        objet.setNom(objetDto.getNom());
        objet.setCout(objetDto.getCout());
        objet.setType(objetDto.getType());
        objet.setAchats(objetDto.getAchats());

        return objet;
    }
}