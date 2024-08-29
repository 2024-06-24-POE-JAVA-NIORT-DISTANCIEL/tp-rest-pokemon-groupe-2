package com.bigcorp.pokemon.dao;

import org.springframework.data.repository.CrudRepository;

import com.bigcorp.pokemon.model.Attaque;

public interface AttaqueDao extends CrudRepository<Attaque, Integer> {
}
