package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.EspeceDao;
import com.bigcorp.pokemon.dto.EspeceDto;
import com.bigcorp.pokemon.model.Espece;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspeceService {

    @Autowired
    EspeceDao especeDao;

    @Transactional
    public EspeceDto save(Espece espece){
        Espece savedEspece = this.especeDao.save(espece);
        return toDto(savedEspece);
    }

    // Récupérer toutes les espèces
    public List<EspeceDto> getAllEspeces() {
        List<Espece> especesDto = (List<Espece>) especeDao.findAll();
        return toDtoList(especesDto);
    }

    public EspeceDto findById(Integer id){
        Optional<Espece> optionalEspece = this.especeDao.findById(id);
        if(optionalEspece.isEmpty()){
            return null;
        }
        return toDto(optionalEspece.get());
    }

    @Transactional
    public boolean delete(Integer id) {
        Optional<Espece> especeInDb = especeDao.findById(id);

        // Test si l'espèce n'est pas présente en base
        // Le ! inverse la condition. On regarde donc ici si la condition est fausse
        if (!especeInDb.isPresent()) {
            return false;
        }

        especeDao.deleteById(id);

        return true;
    }

    public EspeceDto toDto(Espece espece) {
        if (espece == null) {
            return null;
        }
 
        EspeceDto especeDto = new EspeceDto();

        especeDto.setId(espece.getId());
        especeDto.setNom(espece.getNom());
        especeDto.setPointsVieInitial(espece.getPointsVieInitial());
        especeDto.setType(espece.getType());

        return especeDto;
    }

    public List<EspeceDto> toDtoList(List<Espece> especes) {
        List<EspeceDto> especesDto = new ArrayList<>();

        for (Espece espece : especes) {
            EspeceDto currentEspeceToDto = toDto(espece);
            especesDto.add(currentEspeceToDto);
        }

        return especesDto;
    }
}