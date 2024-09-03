package com.bigcorp.pokemon.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.bigcorp.pokemon.dto.AchatDto;
import com.bigcorp.pokemon.model.Achat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.pokemon.dao.DresseurDao;
import com.bigcorp.pokemon.dto.DresseurDto;
import com.bigcorp.pokemon.model.Dresseur;

import jakarta.transaction.Transactional;

@Service
public class DresseurService {
    @Autowired
    private DresseurDao dresseurDao;
    @Autowired
    private AchatService  achatService;

    public DresseurDto save(Dresseur dresseur) {
        Dresseur dresseurSaved = dresseurDao.save(dresseur);
        return toDto(dresseurSaved);
    }

    public DresseurDto getById(Integer id) {
        Optional<Dresseur> dresseurInDb = dresseurDao.findById(id);
        
        if (!dresseurInDb.isPresent()) {
            return null;
        }

        return toDto(dresseurInDb.get());
    }

    public List<DresseurDto> getDresseursByUsernamePart(String pseudonyme) {
        List<Dresseur> dresseursByUsernamePart = dresseurDao.findByPseudonymeContainingIgnoreCaseOrderByPseudonyme(pseudonyme);
        return toDtoList(dresseursByUsernamePart);
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Dresseur> dresseurInDb = dresseurDao.findById(id);

        if (!dresseurInDb.isPresent()) {
            return;
        }

        dresseurDao.delete(dresseurInDb.get());
    }

    // Entitée > DTO
    private DresseurDto toDto(Dresseur dresseur) {
        if (dresseur == null) {
            return null;
        }

        DresseurDto dresseurDto = new DresseurDto();

        dresseurDto.setId(dresseur.getId());
        dresseurDto.setPseudonyme(dresseur.getPseudonyme());
        dresseurDto.setMotDePasse(dresseur.getMotDePasse());
        dresseurDto.setPortefeuille(dresseur.getPortefeuille());
        dresseurDto.setEquipe(dresseur.getEquipe());
        dresseurDto.setInventaire(achatService.toDtoList(dresseur.getInventaire()));

        return dresseurDto;
    }

    private List<DresseurDto> toDtoList(List<Dresseur> dresseurs) {
        List<DresseurDto> dresseursDto = new ArrayList<>();

        for (Dresseur dresseur : dresseurs) {
            DresseurDto currentDresseurToDto = toDto(dresseur);
            dresseursDto.add(currentDresseurToDto);
        }

        return dresseursDto;
    }

    //Pour convertir de DTO > Entitée
    public Dresseur toEntity(DresseurDto dresseurDto) {
        if (dresseurDto == null) {
            return null;
        }
        Dresseur dresseur = new Dresseur();

        dresseur.setId(dresseurDto.getId());
        dresseur.setPseudonyme(dresseurDto.getPseudonyme());
        dresseur.setMotDePasse(dresseurDto.getMotDePasse());
        dresseur.setPortefeuille(dresseurDto.getPortefeuille());
        dresseur.setEquipe(dresseurDto.getEquipe());
        List<Achat>  nouvelInventaire = new ArrayList<>();
        for(AchatDto achatDto : dresseurDto.getInventaire()){
            Achat achat = achatService.toEntity(achatDto, dresseur, null);
            nouvelInventaire.add(achat);
        }
        dresseur.setInventaire(nouvelInventaire);

        return dresseur;
    }
}