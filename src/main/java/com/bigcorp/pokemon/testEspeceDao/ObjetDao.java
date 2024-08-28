package com.bigcorp.pokemon.testEspeceDao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.pokemon.model.Objet;

@Repository
public interface ObjetDao extends CrudRepository<Objet, Integer> {

    public Optional<Objet> findById(Integer id);

    // Fais une requête JPQL personnalisé pour trouver tous les objets qui ont un prix entre min et max
    // et rends ces champs optionnel (:min is null or ... AND :max is null or ...)
    @Query("SELECT o from Objet o WHERE (:min is null OR :min < o.cout) AND (:max is null OR :max > o.cout)")
    public List<Objet> findByCoutBetween(Integer min, Integer max);
}