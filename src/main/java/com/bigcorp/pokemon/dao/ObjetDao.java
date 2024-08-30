package com.bigcorp.pokemon.dao;

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
    // Exemple avec un objet qui a un cout à 4000 avec un min = 2000 et max = 13000 : WHERE 2000 (min) < 4000 AND 13000 (max) > 4000
    // Si min OU max est null, la requête ne le prendra pas en compte et donc, il est bien optionnel
    @Query("SELECT o from Objet o WHERE (:min is null OR :min < o.cout) AND (:max is null OR :max > o.cout)")
    public List<Objet> findByCoutBetween(Integer min, Integer max);
}