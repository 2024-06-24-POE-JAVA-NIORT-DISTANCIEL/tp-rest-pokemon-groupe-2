package com.bigcorp.pokemon.testEspeceDao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.pokemon.model.Dresseur;

@Repository
public interface DresseurDao extends CrudRepository<Dresseur, Integer> {
    // Fais une requête JPQL automatique pour trouver tous les dresseurs possèdant une partie du pseudonyme (Containing), 
    // en ignorant la casse (IgnoreCase) et sont ordonné par ordre croissant (A,B,C,...) selon leur pseudonyme (OrderByPseudonyme)
    public List<Dresseur> findByPseudonymeContainingIgnoreCaseOrderByPseudonyme(String pseudonyme);
}