package com.bigcorp.pokemon.testEspeceDao;

import com.bigcorp.pokemon.model.Espece;
import org.springframework.data.repository.CrudRepository;

public interface EspeceDao extends CrudRepository<Espece,Long> {
}
