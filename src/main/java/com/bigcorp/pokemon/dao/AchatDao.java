package com.bigcorp.pokemon.dao;

import com.bigcorp.pokemon.model.Achat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatDao extends CrudRepository<Achat, Integer> {
}
