package com.bigcorp.pokemon.service;

import com.bigcorp.pokemon.dao.AchatDao;
import com.bigcorp.pokemon.dao.DresseurDao;
import com.bigcorp.pokemon.dao.ObjetDao;
import com.bigcorp.pokemon.dto.AchatDto;
import com.bigcorp.pokemon.dto.DresseurDto;
import com.bigcorp.pokemon.dto.ObjetDto;
import com.bigcorp.pokemon.dto.PokemonDto;
import com.bigcorp.pokemon.model.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AchatService {

    @Autowired
    private AchatDao achatDao;

    @Autowired
    private DresseurDao dresseurDao;

    @Autowired
    private ObjetDao objetDao;

    @Autowired
    ObjetService objetService;

    @Autowired
    DresseurService dresseurService;

    @Transactional
    public Achat acheterObjet(DresseurDto dresseurDto, ObjetDto objetDto){

        if (dresseurDto == null && objetDto == null){
            return null;
        }

        // Crée l'achat
        AchatDto achatDto = new AchatDto();

        //On vérifie que le portefeuille et l'objet ne sont pas null
        if (dresseurDto.getPortefeuille() == null || objetDto.getCout() == null){
            return null;
        }

        // Décrémente le portefeuille du dresseur
        dresseurDto.setPortefeuille(dresseurDto.getPortefeuille() - objetDto.getCout());

        //conversion dresseurDto > dresseur
        Dresseur dresseurDtoToEntity = dresseurService.toEntity(dresseurDto);
        achatDto.setDresseurId(dresseurDtoToEntity.getId());

        //conversion objetDto > objet
        Objet objetDtoToEntity = objetService.toEntity(objetDto);
        achatDto.setObjetId(objetDtoToEntity.getId());

        //conversion achatDto > achat
        Achat achatDtoToEntity = toEntity(achatDto, dresseurDtoToEntity, objetDtoToEntity);

        //sauvegarde un achat et on le converti en DTO
        AchatDto savedAchatDto = toDto(achatDao.save(achatDtoToEntity)); // Sauvegarde l'achat

        //récupération de l'inventaire du dresseurDto
        List<Achat> inventaire = dresseurDto.getInventaire();

        //conversion de liste d'achat en liste d'achatDto
        List<AchatDto> inventaireDto = toDtoList(inventaire); //récupération de la liste  des achats

        inventaire.add(achatDtoToEntity); // on lui rajoute l'achat save
        dresseurDto.setInventaire(inventaire); // mise à jour de l'inventaire

        dresseurDao.save(dresseurDtoToEntity); // Sauvegarde le dresseur mis à jour

        return achatDtoToEntity;
    }

    private AchatDto toDto(Achat achat) {
        if (achat == null) {
            return null;
        }

        AchatDto achatDto = new AchatDto();

        achatDto.setId(achat.getId());
        achatDto.setDresseurId(achat.getDresseur().getId());
        achatDto.setObjetId(achat.getObjet().getId());

        return achatDto;
    }

    public List<AchatDto> toDtoList(List<Achat> achats) {
        List<AchatDto> achatsDto = new ArrayList<>();

        for (Achat achat : achats) {
            AchatDto currentAchatToDto = toDto(achat);
            achatsDto.add(currentAchatToDto);
        }

        return achatsDto;
    }

    //Pour convertir de DTO > Entitée
    public Achat toEntity(AchatDto achatDto, Dresseur dresseur, Objet objet) {
        if (achatDto == null) {
            return null;
        }
        Achat achat = new Achat();

        achat.setId(achatDto.getId());
        achat.setDresseur(dresseur);
        achat.setObjet(objet);

        return achat;
    }
}
