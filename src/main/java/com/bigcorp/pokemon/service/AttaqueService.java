package com.bigcorp.pokemon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.pokemon.dao.AttaqueDao;
import com.bigcorp.pokemon.dto.AttaqueDTO;
import com.bigcorp.pokemon.model.Attaque;

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

    private static class AttaqueDto {

        public AttaqueDto() {
        }
    }

    public class AttaqueMapper {
    public static AttaqueDTO toDto(Attaque attaque) {
        AttaqueDTO dto = new AttaqueDTO();
        dto.setId(attaque.getId());
        dto.setNom(attaque.getNom());
        dto.setType(attaque.getType());
        dto.setPointsDegats(attaque.getPointsDegats());
        return dto;
    }

    public static Attaque toEntity(AttaqueDTO dto) {
        Attaque attaque = new Attaque();
        attaque.setId(dto.getId());
        attaque.setNom(dto.getNom());
        attaque.setType(dto.getType());
        attaque.setPointsDegats(dto.getPointsDegats());
        return attaque;
    }
}

    private List<AttaqueDto> toDtoList(List<Attaque> attaque) {
        List<AttaqueDto> attaqueDto = new ArrayList<>();
            AttaqueDto currentAttaqueToDto = (AttaqueDto) toDtoList(attaque);
            attaqueDto.add(currentAttaqueToDto);

        return attaqueDto;
    }
}
